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
package dev.siliconcode.auto_mt.lib.parserop.swift

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.swift.Swift5Parser
import dev.siliconcode.auto_mt.parsers.swift.Swift5ParserBaseListener

abstract class SwiftAbstractExtractor extends Swift5ParserBaseListener {

    private ModelBuilder modelBuilder

    SwiftAbstractExtractor(ModelBuilder builder) {
        this.modelBuilder = builder
    }

    @Override
    void enterEnum_declaration(Swift5Parser.Enum_declarationContext ctx) {
        super.enterEnum_declaration(ctx)
    }

    @Override
    void exitEnum_declaration(Swift5Parser.Enum_declarationContext ctx) {
        super.exitEnum_declaration(ctx)
    }

    @Override
    void enterStruct_declaration(Swift5Parser.Struct_declarationContext ctx) {
        super.enterStruct_declaration(ctx)
    }

    @Override
    void exitStruct_declaration(Swift5Parser.Struct_declarationContext ctx) {
        super.exitStruct_declaration(ctx)
    }

    @Override
    void enterClass_declaration(Swift5Parser.Class_declarationContext ctx) {
        super.enterClass_declaration(ctx)
    }

    @Override
    void exitClass_declaration(Swift5Parser.Class_declarationContext ctx) {
        super.exitClass_declaration(ctx)
    }

    @Override
    void enterProtocol_declaration(Swift5Parser.Protocol_declarationContext ctx) {
        super.enterProtocol_declaration(ctx)
    }

    @Override
    void exitProtocol_declaration(Swift5Parser.Protocol_declarationContext ctx) {
        super.exitProtocol_declaration(ctx)
    }

    @Override
    void enterExtension_declaration(Swift5Parser.Extension_declarationContext ctx) {
        super.enterExtension_declaration(ctx)
    }

    @Override
    void exitExtension_declaration(Swift5Parser.Extension_declarationContext ctx) {
        super.exitExtension_declaration(ctx)
    }

    @Override
    void enterFunction_declaration(Swift5Parser.Function_declarationContext ctx) {
        super.enterFunction_declaration(ctx)
    }

    @Override
    void exitFunction_declaration(Swift5Parser.Function_declarationContext ctx) {
        super.exitFunction_declaration(ctx)
    }

    @Override
    void enterProtocol_method_declaration(Swift5Parser.Protocol_method_declarationContext ctx) {
        super.enterProtocol_method_declaration(ctx)
    }

    @Override
    void exitProtocol_method_declaration(Swift5Parser.Protocol_method_declarationContext ctx) {
        super.exitProtocol_method_declaration(ctx)
    }

    @Override
    void enterProtocol_initializer_declaration(Swift5Parser.Protocol_initializer_declarationContext ctx) {
        super.enterProtocol_initializer_declaration(ctx)
    }

    @Override
    void exitProtocol_initializer_declaration(Swift5Parser.Protocol_initializer_declarationContext ctx) {
        super.exitProtocol_initializer_declaration(ctx)
    }

    @Override
    void enterInitializer_declaration(Swift5Parser.Initializer_declarationContext ctx) {
        super.enterInitializer_declaration(ctx)
    }

    @Override
    void exitInitializer_declaration(Swift5Parser.Initializer_declarationContext ctx) {
        super.exitInitializer_declaration(ctx)
    }

    @Override
    void enterDeinitializer_declaration(Swift5Parser.Deinitializer_declarationContext ctx) {
        super.enterDeinitializer_declaration(ctx)
    }

    @Override
    void exitDeinitializer_declaration(Swift5Parser.Deinitializer_declarationContext ctx) {
        super.exitDeinitializer_declaration(ctx)
    }

    @Override
    void enterOperator_declaration(Swift5Parser.Operator_declarationContext ctx) {
        super.enterOperator_declaration(ctx)
    }

    @Override
    void exitOperator_declaration(Swift5Parser.Operator_declarationContext ctx) {
        super.exitOperator_declaration(ctx)
    }

    @Override
    void enterPrefix_operator_declaration(Swift5Parser.Prefix_operator_declarationContext ctx) {
        super.enterPrefix_operator_declaration(ctx)
    }

    @Override
    void exitPrefix_operator_declaration(Swift5Parser.Prefix_operator_declarationContext ctx) {
        super.exitPrefix_operator_declaration(ctx)
    }

    @Override
    void enterPostfix_operator_declaration(Swift5Parser.Postfix_operator_declarationContext ctx) {
        super.enterPostfix_operator_declaration(ctx)
    }

    @Override
    void exitPostfix_operator_declaration(Swift5Parser.Postfix_operator_declarationContext ctx) {
        super.exitPostfix_operator_declaration(ctx)
    }

    @Override
    void enterInfix_operator_declaration(Swift5Parser.Infix_operator_declarationContext ctx) {
        super.enterInfix_operator_declaration(ctx)
    }

    @Override
    void exitInfix_operator_declaration(Swift5Parser.Infix_operator_declarationContext ctx) {
        super.exitInfix_operator_declaration(ctx)
    }
}
