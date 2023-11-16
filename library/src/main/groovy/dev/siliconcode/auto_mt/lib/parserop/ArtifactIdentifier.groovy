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
import groovy.transform.ToString
import groovy.util.logging.Slf4j

import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

@Slf4j
@ToString(includeNames = true, includePackage = false)
class ArtifactIdentifier {

    Map<FileType, Integer> counts
    List<ProjectFile> files
    Project project
    String language
    List<String> sourceFileExtensions
    List<String> binaryFileExtensions
    List<String> buildFileTypes
    List<String> buildFileExtensions
    List<String> moduleFileTypes
    List<String> moduleFileExtensions
    List<String> documentationFileTypes

    ArtifactIdentifier() {
        this.counts = [:]
        this.files = []
    }

    void identify(String root) {
        Path rootPath = Paths.get root
        log.info "Root Path: $rootPath"
        log.info "Absolute Path: ${rootPath.toAbsolutePath()}"

        try {
            Files.walkFileTree(rootPath.toAbsolutePath(), new ArtifactFileVisitor())
        } catch (IOException e) {
            log.error "Error walking file tree: $e"
        }

        log.info "File counts:"
        counts.each { type, count -> log.info "\t${type}: ${count}" }
        log.info "Files found: ${files.size()}"
    }

    void setProject(Project project) {
        this.project = project
    }

    private void incrementCount(FileType type) {
        if (counts.containsKey(type))
            counts[type] += 1
        else
            counts[type] = 1
    }

    List<String> getDocumentationFileTypes() {
        return ['readme.md', 'readme.rst', 'readme.txt',
                'license', 'license.txt', 'changelog.md'] +
                documentationFileTypes
    }

    private class ArtifactFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            FileType type = null
            String fileName = file.getFileName().toString()
            if (fileName in getBuildFileTypes() || fileName in getBuildFileExtensions()) {
                type = FileType.BUILD
            } else if (getExtension(fileName) in getBinaryFileExtensions()) {
                type = FileType.BINARY
            } else if (fileName in getModuleFileTypes() || getExtension(fileName) in getModuleFileExtensions()) {
                type = FileType.MODULE
            } else if (fileName in getDocumentationFileTypes()) {
                type = FileType.DOC
            } else if (getExtension(fileName) in getSourceFileExtensions()) {
                type = FileType.SOURCE
                if (file.getParent().toString().toLowerCase().contains("test"))
                    type = FileType.TEST
            }

            if (type != null) {
                if (!project.getFileByName(file.toString())) {
                    ProjectFile f = ProjectFile.builder()
                            .key(project.getKey() + ":" + file.toString())
                            .name(file.toString())
                            .relPath(file.getFileName().toString())
                            .language(getLanguage())
                            .type(type)
                            .build()
                    files.add(f)
                    if (project.files)
                        project.files += f
                    else
                        project.files = [f]
                    if (type == FileType.SOURCE) {
                        int end = file.toFile().readLines().size()
                        int start = 1
                        f.setStart(start)
                        f.setEnd(end)
                    }
                } else {
                    ProjectFile f = project.getFileByName(file.toString())
                    files.add(f)
                }
                incrementCount(type)
                log.info "Identified ${type} file: ${file.getFileName()}"
            }

            return FileVisitResult.CONTINUE
        }

        @Override
        FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            log.info "Checking Path: ${dir.toString()}"

            return FileVisitResult.CONTINUE
        }

        @Override
        FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (dir.getFileName().toString().equals(".git") || dir.getFileName().toString().equals(".idea"))
                return FileVisitResult.SKIP_SUBTREE

            return FileVisitResult.CONTINUE
        }

        private String getExtension(String fileName) {
            return fileName.toString().split("\\.").last()
        }
    }
}
