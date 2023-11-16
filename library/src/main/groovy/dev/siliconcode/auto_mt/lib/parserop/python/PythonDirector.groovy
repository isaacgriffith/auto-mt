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
package dev.siliconcode.auto_mt.lib.parserop.python

import dev.siliconcode.auto_mt.lib.code.FileType
import dev.siliconcode.auto_mt.lib.code.Project
import dev.siliconcode.auto_mt.lib.code.ProjectFile
import dev.siliconcode.auto_mt.lib.parserop.ArtifactIdentifierRegistrar
import dev.siliconcode.auto_mt.lib.parserop.BaseDirector
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.univ_python.PythonParser
import groovy.util.logging.Slf4j
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ParseTreeListener

@Slf4j
class PythonDirector extends BaseDirector {

    PythonDirector(Project proj, boolean statements = true, boolean useSinglePass = false, boolean createCFG = true, boolean useExpressions = false) {
        super(proj, ArtifactIdentifierRegistrar.instance.getArtifactIdentifier('python'), statements, useSinglePass, createCFG, useExpressions)
    }

    @Override
    ParseTreeListener createStatementExtractor(ModelBuilder builder) {
        return new PythonStatementExtractor(builder)
    }

    @Override
    ParseTreeListener createFileAndTypeExtractor(ModelBuilder builder) {
        return new PythonFileAndTypeExtractor(builder)
    }

    @Override
    ParserConstructor createParserConstructor() {
        return new PythonParserConstructor()
    }

    @Override
    ParserRuleContext getRootContext(Parser parser) {
        if (!(parser instanceof PythonParser)) {
            throw new IllegalArgumentException("Parser must be of type PythonParser")
        }

        return parser.root()
    }

    static void main(String[] args) {
        Project project = Project.builder()
                .key("Python Examples")
                .version("1.0")
                .srcPath("")
                .build()
        PythonDirector director = new PythonDirector(project)
        director.build("library/examples")

        project.getFilesByType(FileType.SOURCE).each { ProjectFile file ->
            println(file)
            println(file.script)
            println(file.script.getCfg())
            println(file.script.getCfg()?.cfgToString())
        }
    }
}

