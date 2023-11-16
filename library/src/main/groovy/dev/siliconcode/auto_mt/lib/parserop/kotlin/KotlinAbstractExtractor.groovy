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
package dev.siliconcode.auto_mt.lib.parserop.kotlin

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.kotlin.KotlinParser
import dev.siliconcode.auto_mt.parsers.kotlin.KotlinParserBaseListener

abstract class KotlinAbstractExtractor extends KotlinParserBaseListener {

    private ModelBuilder modelBuilder

    KotlinAbstractExtractor(ModelBuilder builder) {
        this.modelBuilder = builder
    }

    @Override
    void enterClassDeclaration(KotlinParser.ClassDeclarationContext ctx) {
        super.enterClassDeclaration(ctx)
    }

    @Override
    void exitClassDeclaration(KotlinParser.ClassDeclarationContext ctx) {
        super.exitClassDeclaration(ctx)
    }

    @Override
    void enterObjectDeclaration(KotlinParser.ObjectDeclarationContext ctx) {
        super.enterObjectDeclaration(ctx)
    }

    @Override
    void exitObjectDeclaration(KotlinParser.ObjectDeclarationContext ctx) {
        super.exitObjectDeclaration(ctx)
    }

    @Override
    void enterFunctionDeclaration(KotlinParser.FunctionDeclarationContext ctx) {
        super.enterFunctionDeclaration(ctx)
    }

    @Override
    void exitFunctionDeclaration(KotlinParser.FunctionDeclarationContext ctx) {
        super.exitFunctionDeclaration(ctx)
    }

    @Override
    void enterPropertyDeclaration(KotlinParser.PropertyDeclarationContext ctx) {
        super.enterPropertyDeclaration(ctx)
    }

    @Override
    void exitPropertyDeclaration(KotlinParser.PropertyDeclarationContext ctx) {
        super.exitPropertyDeclaration(ctx)
    }
}
