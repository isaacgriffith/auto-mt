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

abstract class CSharpAbstractExtractor extends CSharpParserBaseListener {

    protected ModelBuilder builder

    CSharpAbstractExtractor(ModelBuilder builder) {
        this.builder = builder
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

    @Override
    void enterAccessor_declarations(CSharpParser.Accessor_declarationsContext ctx) {
        super.enterAccessor_declarations(ctx)
    }

    @Override
    void exitAccessor_declarations(CSharpParser.Accessor_declarationsContext ctx) {
        super.exitAccessor_declarations(ctx)
    }

    @Override
    void enterGet_accessor_declaration(CSharpParser.Get_accessor_declarationContext ctx) {
        super.enterGet_accessor_declaration(ctx)
    }

    @Override
    void exitGet_accessor_declaration(CSharpParser.Get_accessor_declarationContext ctx) {
        super.exitGet_accessor_declaration(ctx)
    }

    @Override
    void enterSet_accessor_declaration(CSharpParser.Set_accessor_declarationContext ctx) {
        super.enterSet_accessor_declaration(ctx)
    }

    @Override
    void exitSet_accessor_declaration(CSharpParser.Set_accessor_declarationContext ctx) {
        super.exitSet_accessor_declaration(ctx)
    }

    @Override
    void enterEvent_accessor_declarations(CSharpParser.Event_accessor_declarationsContext ctx) {
        super.enterEvent_accessor_declarations(ctx)
    }

    @Override
    void exitEvent_accessor_declarations(CSharpParser.Event_accessor_declarationsContext ctx) {
        super.exitEvent_accessor_declarations(ctx)
    }

    @Override
    void enterAdd_accessor_declaration(CSharpParser.Add_accessor_declarationContext ctx) {
        super.enterAdd_accessor_declaration(ctx)
    }

    @Override
    void exitAdd_accessor_declaration(CSharpParser.Add_accessor_declarationContext ctx) {
        super.exitAdd_accessor_declaration(ctx)
    }

    @Override
    void enterRemove_accessor_declaration(CSharpParser.Remove_accessor_declarationContext ctx) {
        super.enterRemove_accessor_declaration(ctx)
    }

    @Override
    void exitRemove_accessor_declaration(CSharpParser.Remove_accessor_declarationContext ctx) {
        super.exitRemove_accessor_declaration(ctx)
    }

    @Override
    void enterEvent_declaration(CSharpParser.Event_declarationContext ctx) {
        super.enterEvent_declaration(ctx)
    }

    @Override
    void exitEvent_declaration(CSharpParser.Event_declarationContext ctx) {
        super.exitEvent_declaration(ctx)
    }

    @Override
    void enterProperty_declaration(CSharpParser.Property_declarationContext ctx) {
        super.enterProperty_declaration(ctx)
    }

    @Override
    void enterIndexer_declaration(CSharpParser.Indexer_declarationContext ctx) {
        super.enterIndexer_declaration(ctx)
    }

    @Override
    void exitIndexer_declaration(CSharpParser.Indexer_declarationContext ctx) {
        super.exitIndexer_declaration(ctx)
    }

    @Override
    void enterConstructor_declaration(CSharpParser.Constructor_declarationContext ctx) {
        super.enterConstructor_declaration(ctx)
    }

    @Override
    void exitConstructor_declaration(CSharpParser.Constructor_declarationContext ctx) {
        super.exitConstructor_declaration(ctx)
    }

    @Override
    void enterMethod_declaration(CSharpParser.Method_declarationContext ctx) {
        super.enterMethod_declaration(ctx)
    }

    @Override
    void exitMethod_declaration(CSharpParser.Method_declarationContext ctx) {
        super.exitMethod_declaration(ctx)
    }

    @Override
    void enterOperator_declaration(CSharpParser.Operator_declarationContext ctx) {
        super.enterOperator_declaration(ctx)
    }

    @Override
    void exitOperator_declaration(CSharpParser.Operator_declarationContext ctx) {
        super.exitOperator_declaration(ctx)
    }
}
