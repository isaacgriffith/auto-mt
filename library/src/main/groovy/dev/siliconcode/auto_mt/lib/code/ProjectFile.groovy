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
package dev.siliconcode.auto_mt.lib.code

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder

@ToString(includeNames = false, includePackage = false, includes = ['name'])
@EqualsAndHashCode(includes = ['name'])
class ProjectFile {

    String name
    String path
    String relPath
    String key
    FileType type
    String language
    int start
    int end
    int parseStage
    final Script script

    @Builder
    ProjectFile(String name, String path, String relPath, String key, FileType type, String language, int start, int end, int parseStage) {
        this.name = name
        this.path = path
        this.relPath = relPath
        this.key = key
        this.type = type
        this.language = language
        this.start = start
        this.end = end
        this.parseStage = parseStage
        this.script = new Script(name)
    }
}

enum FileType {

    SOURCE,
    TEST,
    BUILD,
    SCM,
    CI,
    DOC,
    CONFIG,
    BINARY,
    MODULE
}
