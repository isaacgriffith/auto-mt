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
package dev.siliconcode.auto_mt.lib.parserop.js

import dev.siliconcode.auto_mt.lib.code.TypeType
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.js.JavaScriptParser
import dev.siliconcode.auto_mt.parsers.js.JavaScriptParserBaseListener
import groovy.util.logging.Slf4j

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class JavaScriptFileAndTypeExtractor extends JavaScriptParserBaseListener {

    ModelBuilder modelBuilder
    boolean inTypeDecl = false

    JavaScriptFileAndTypeExtractor(ModelBuilder builder) {
        modelBuilder = builder
    }

    @Override
    void enterClassDeclaration(JavaScriptParser.ClassDeclarationContext ctx) {
        inTypeDecl = true
        log.info "${modelBuilder.getFile().getName()} Entering Class Declaration"

        def typeName = ctx.identifier()?.getText()
        def start = ctx.start.line
        def end = ctx.stop.line

        modelBuilder.createType(typeName, TypeType.CLASS, start, end)

        super.enterClassDeclaration(ctx)
    }

    @Override
    void exitClassDeclaration(JavaScriptParser.ClassDeclarationContext ctx) {
        modelBuilder.endType()
        inTypeDecl = false

        super.exitClassDeclaration(ctx)
    }
}
