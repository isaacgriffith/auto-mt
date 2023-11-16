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
package dev.siliconcode.auto_mt.lib.parserop.ts

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.ts.TypeScriptParser
import dev.siliconcode.auto_mt.parsers.ts.TypeScriptParserBaseListener

class TypeScriptFileAndTypeExtractor extends TypeScriptParserBaseListener {

    ModelBuilder modelBuilder
    boolean inTypeDecl = false

    TypeScriptFileAndTypeExtractor(ModelBuilder builder) {
        modelBuilder = builder
    }

    @Override
    void enterInterfaceDeclaration(TypeScriptParser.InterfaceDeclarationContext ctx) {
        super.enterInterfaceDeclaration(ctx)
    }

    @Override
    void exitInterfaceDeclaration(TypeScriptParser.InterfaceDeclarationContext ctx) {
        super.exitInterfaceDeclaration(ctx)
    }

    @Override
    void enterEnumDeclaration(TypeScriptParser.EnumDeclarationContext ctx) {
        super.enterEnumDeclaration(ctx)
    }

    @Override
    void exitEnumDeclaration(TypeScriptParser.EnumDeclarationContext ctx) {
        super.exitEnumDeclaration(ctx)
    }

    @Override
    void enterClassDeclaration(TypeScriptParser.ClassDeclarationContext ctx) {
        super.enterClassDeclaration(ctx)
    }

    @Override
    void exitClassDeclaration(TypeScriptParser.ClassDeclarationContext ctx) {
        super.exitClassDeclaration(ctx)
    }
}
