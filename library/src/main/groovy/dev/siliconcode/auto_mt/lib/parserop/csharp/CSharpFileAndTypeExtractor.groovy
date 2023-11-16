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
package dev.siliconcode.auto_mt.lib.parserop.csharp

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.csharp.CSharpParser
import dev.siliconcode.auto_mt.parsers.csharp.CSharpParserBaseListener

class CSharpFileAndTypeExtractor extends CSharpParserBaseListener {

    ModelBuilder builder;
    boolean inTypeDecl = false;

    CSharpFileAndTypeExtractor(ModelBuilder builder) {
        this.builder = builder;
    }

    @Override
    void enterClass_definition(CSharpParser.Class_definitionContext ctx) {
        super.enterClass_definition(ctx)
    }

    @Override
    void exitClass_definition(CSharpParser.Class_definitionContext ctx) {
        super.exitClass_definition(ctx)
    }

    @Override
    void enterStruct_definition(CSharpParser.Struct_definitionContext ctx) {
        super.enterStruct_definition(ctx)
    }

    @Override
    void exitStruct_definition(CSharpParser.Struct_definitionContext ctx) {
        super.exitStruct_definition(ctx)
    }

    @Override
    void enterInterface_definition(CSharpParser.Interface_definitionContext ctx) {
        super.enterInterface_definition(ctx)
    }

    @Override
    void exitInterface_definition(CSharpParser.Interface_definitionContext ctx) {
        super.exitInterface_definition(ctx)
    }

    @Override
    void enterEnum_definition(CSharpParser.Enum_definitionContext ctx) {
        super.enterEnum_definition(ctx)
    }

    @Override
    void exitEnum_definition(CSharpParser.Enum_definitionContext ctx) {
        super.exitEnum_definition(ctx)
    }

    @Override
    void enterDelegate_definition(CSharpParser.Delegate_definitionContext ctx) {
        super.enterDelegate_definition(ctx)
    }

    @Override
    void exitDelegate_definition(CSharpParser.Delegate_definitionContext ctx) {
        super.exitDelegate_definition(ctx)
    }

    @Override
    void enterDestructor_definition(CSharpParser.Destructor_definitionContext ctx) {
        super.enterDestructor_definition(ctx)
    }

    @Override
    void exitDestructor_definition(CSharpParser.Destructor_definitionContext ctx) {
        super.exitDestructor_definition(ctx)
    }
}
