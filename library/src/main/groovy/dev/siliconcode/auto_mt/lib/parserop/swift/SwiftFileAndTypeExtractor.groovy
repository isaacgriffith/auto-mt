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

class SwiftFileAndTypeExtractor extends Swift5ParserBaseListener {

    ModelBuilder modelBuilder
    boolean inTypeDecl = false

    SwiftFileAndTypeExtractor(ModelBuilder builder) {
        modelBuilder = builder
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
}
