/*
 * MIT License
 *
 * SiliconCode AutoMT - Library
 * Copyright (c) 2023 SiliconCode, LLC and Isaac Griffith, PhD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.siliconcode.auto_mt.lib.parserop

import dev.siliconcode.auto_mt.lib.code.FileType
import dev.siliconcode.auto_mt.lib.code.Project
import dev.siliconcode.auto_mt.lib.code.ProjectFile
import groovy.util.logging.Slf4j
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.tree.ParseTreeListener
import org.antlr.v4.runtime.tree.ParseTreeWalker

import java.util.concurrent.atomic.AtomicInteger

@Slf4j
abstract class BaseDirector implements Director {

    boolean statements
    boolean useSinglePass
    boolean createCFG
    boolean useExpressions
    protected Project project
    protected ArtifactIdentifier identifier
    protected ModelBuilder builder
    int current
    int total

    BaseDirector(Project project, ArtifactIdentifier identifier, boolean statements = false, boolean useSinglePass = false, boolean createCFG = false, boolean useExpressions = false) {
        this.project = project
        this.identifier = identifier
        this.builder = null
        this.statements = statements
        this.useSinglePass = useSinglePass
        this.createCFG = createCFG
        this.useExpressions = useExpressions
        identifier?.setProject(project)
    }

    void build(String path) {
        identify(project, path)

        List<ProjectFile> files = []
        files += project.getFilesByType(FileType.SOURCE)
        files.removeIf { it.getScript().getTypes().size() > 0 && it.parseStage > 0 }

        process(files)
    }

    void identify(Project project, String path) {
        identifier.setProject(project)
        identifier.identify(path)
    }

    void process(final List<ProjectFile> files) {
        log.info "Processing files and their contained info"

        if (useSinglePass) {
            log.info "Parsing and extracting file info"

            int total = files.size()
            AtomicInteger current = new AtomicInteger(1)
//            GParsPool.withPool(8) {
//                files.eachParallel { File file ->
                files.each { ProjectFile file ->
                    int index = current.getAndIncrement()
                    if (includeFile(file)) {
                        gatherAllInfoAtOnce(file, index, total)
                    }
                }
//            }
        } else {
            current = 1
            total = files.size()
            log.info "Gathering File and Type Info into Model"
            files.each { ProjectFile file ->
                log.info "File: $file"
                if (includeFile(file))
                    gatherFileAndTypeInfo(file)
                current += 1
            }

            log.info "Gathering Type Members and Basic Relation Info into Model"
            current = 1
            files.each { ProjectFile file ->
                if (includeFile(file))
                    gatherMembersAndBasicRelationInfo(file)
                current += 1
            }

            log.info "Gathering Member Usage Info into Model"
            current = 1
            files.each { ProjectFile file ->
                if (includeFile(file))
                    gatherMemberUsageInfo(file)
                current += 1
            }

            if (statements) {
                current = 1
                log.info "Gathering Statement Info and CFG into Model"
                files.each { ProjectFile file ->
                    if (includeFile(file))
                        gatherStatementInfo(file)
                    current += 1
                }
            }
        }

        log.info "Gathering Type Associations into Model"
        gatherTypeAssociations()
        log.info "File processing complete"
    }

    void gatherAllInfoAtOnce(ProjectFile file, int current, int total) {
//        log.info "Parsing File: ${file.getName()}"
//
//        builder = PythonModelBuilder(project, file)
//        boolean processed = file.getParseStage() < 1 || file.getAllTypes().size() > 0
//
//        if (processed) {
//            utilizeParser(file, new PythonSinglePassExtractor(builder, createCFG, useExpressions), current, total)
//            file.setParseStage(1)
//        }
    }

    void gatherFileAndTypeInfo(ProjectFile file) {
        int stage = file.getParseStage()

        if (stage >= 1)
            return

        builder = new ModelBuilder(project, file)
        utilizeParser(file, createFileAndTypeExtractor(builder))

        file.setParseStage(1)
    }

    void gatherMembersAndBasicRelationInfo(ProjectFile file) {
//        int stage = file.getParseStage()
//
//        if (stage >= 2)
//            return
//
//        BaseModelBuilder builder = new PythonModelBuilder(project, file)
//        utilizeParser(file, new PythonMemberAndRelExtractor(builder))
//
//        file.setParseStage(2)
    }

    void gatherMemberUsageInfo(ProjectFile file) {

    }

    void gatherStatementInfo(ProjectFile file) {
        int stage = file.getParseStage()

        if (stage >= 3)
            return

        ModelBuilder builder = new ModelBuilder(project, file)
        builder.setFile(file)
        utilizeParser(file, createStatementExtractor(builder))

        file.setParseStage(3)
    }

    void gatherTypeAssociations() {

    }

    boolean includeFile(ProjectFile file) {
        file.getType() == FileType.SOURCE && file.getLanguage() == this.identifier.getLanguage()
    }

    void utilizeParser(ProjectFile file, ParseTreeListener listener) {
        String path = file.getName()

        log.info "Parsing ($current / $total)... $path"

        try {
            final ParserConstructor pt = createParserConstructor()
            final Parser parser = pt.loadFile(path)
            final ParserRuleContext rootCtx = getRootContext(parser)
            final ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, rootCtx)
        } catch (final IOException | RecognitionException e) {
            log.error e.getMessage()
        }
    }

    abstract ParseTreeListener createStatementExtractor(ModelBuilder builder)

    abstract ParseTreeListener createFileAndTypeExtractor(ModelBuilder builder)

    abstract ParserConstructor createParserConstructor()

    abstract ParserRuleContext getRootContext(Parser parser)
}
