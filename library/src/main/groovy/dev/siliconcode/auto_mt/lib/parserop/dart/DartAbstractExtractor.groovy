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
package dev.siliconcode.auto_mt.lib.parserop.dart

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.dart.Dart2Parser
import dev.siliconcode.auto_mt.parsers.dart.Dart2ParserBaseListener
import dev.siliconcode.auto_mt.parsers.univ_python.PythonParser
import org.antlr.v4.runtime.tree.TerminalNode

abstract class DartAbstractExtractor extends Dart2ParserBaseListener {

    protected ModelBuilder modelBuilder

    DartAbstractExtractor(ModelBuilder builder) {
        this.modelBuilder = builder
    }

    protected String createSignature(TerminalNode identifier, PythonParser.TypedargslistContext argsListContext) {
        ''
    }

    @Override
    void enterClassDeclaration(Dart2Parser.ClassDeclarationContext ctx) {
        super.enterClassDeclaration(ctx)
    }

    @Override
    void exitClassDeclaration(Dart2Parser.ClassDeclarationContext ctx) {
        super.exitClassDeclaration(ctx)
    }

    @Override
    void enterExtensionDeclaration(Dart2Parser.ExtensionDeclarationContext ctx) {
        super.enterExtensionDeclaration(ctx)
    }

    @Override
    void exitExtensionDeclaration(Dart2Parser.ExtensionDeclarationContext ctx) {
        super.exitExtensionDeclaration(ctx)
    }

    @Override
    void enterLibraryDeclaration(Dart2Parser.LibraryDeclarationContext ctx) {
        super.enterLibraryDeclaration(ctx)
    }

    @Override
    void exitLibraryDeclaration(Dart2Parser.LibraryDeclarationContext ctx) {
        super.exitLibraryDeclaration(ctx)
    }

    @Override
    void enterMixinDeclaration(Dart2Parser.MixinDeclarationContext ctx) {
        super.enterMixinDeclaration(ctx)
    }

    @Override
    void exitMixinDeclaration(Dart2Parser.MixinDeclarationContext ctx) {
        super.exitMixinDeclaration(ctx)
    }

    @Override
    void enterPartDeclaration(Dart2Parser.PartDeclarationContext ctx) {
        super.enterPartDeclaration(ctx)
    }

    @Override
    void exitPartDeclaration(Dart2Parser.PartDeclarationContext ctx) {
        super.exitPartDeclaration(ctx)
    }

    @Override
    void enterLocalFunctionDeclaration(Dart2Parser.LocalFunctionDeclarationContext ctx) {
        super.enterLocalFunctionDeclaration(ctx)
    }

    @Override
    void exitLocalFunctionDeclaration(Dart2Parser.LocalFunctionDeclarationContext ctx) {
        super.exitLocalFunctionDeclaration(ctx)
    }
}
