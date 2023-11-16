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
package dev.siliconcode.auto_mt.lib.parserop.objc

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.objc.ObjectiveCParser
import dev.siliconcode.auto_mt.parsers.objc.ObjectiveCParserBaseListener

abstract class ObjCAbstractExtractor extends ObjectiveCParserBaseListener {

    private ModelBuilder modelBuilder

    ObjCAbstractExtractor(ModelBuilder builder) {
        this.modelBuilder = builder
    }

    @Override
    void enterClassInterface(ObjectiveCParser.ClassInterfaceContext ctx) {
        super.enterClassInterface(ctx)
    }

    @Override
    void exitClassInterface(ObjectiveCParser.ClassInterfaceContext ctx) {
        super.exitClassInterface(ctx)
    }

    @Override
    void enterClassImplementation(ObjectiveCParser.ClassImplementationContext ctx) {
        super.enterClassImplementation(ctx)
    }

    @Override
    void exitClassImplementation(ObjectiveCParser.ClassImplementationContext ctx) {
        super.exitClassImplementation(ctx)
    }

    @Override
    void enterInterfaceDeclarationList(ObjectiveCParser.InterfaceDeclarationListContext ctx) {
        super.enterInterfaceDeclarationList(ctx)
    }

    @Override
    void exitInterfaceDeclarationList(ObjectiveCParser.InterfaceDeclarationListContext ctx) {
        super.exitInterfaceDeclarationList(ctx)
    }

    @Override
    void enterEnumDeclaration(ObjectiveCParser.EnumDeclarationContext ctx) {
        super.enterEnumDeclaration(ctx)
    }

    @Override
    void exitEnumDeclaration(ObjectiveCParser.EnumDeclarationContext ctx) {
        super.exitEnumDeclaration(ctx)
    }

    @Override
    void enterProtocolDeclaration(ObjectiveCParser.ProtocolDeclarationContext ctx) {
        super.enterProtocolDeclaration(ctx)
    }

    @Override
    void exitProtocolDeclaration(ObjectiveCParser.ProtocolDeclarationContext ctx) {
        super.exitProtocolDeclaration(ctx)
    }

    @Override
    void enterPropertyDeclaration(ObjectiveCParser.PropertyDeclarationContext ctx) {
        super.enterPropertyDeclaration(ctx)
    }

    @Override
    void exitPropertyDeclaration(ObjectiveCParser.PropertyDeclarationContext ctx) {
        super.exitPropertyDeclaration(ctx)
    }

    @Override
    void enterClassMethodDeclaration(ObjectiveCParser.ClassMethodDeclarationContext ctx) {
        super.enterClassMethodDeclaration(ctx)
    }

    @Override
    void exitClassMethodDeclaration(ObjectiveCParser.ClassMethodDeclarationContext ctx) {
        super.exitClassMethodDeclaration(ctx)
    }

    @Override
    void enterInstanceMethodDeclaration(ObjectiveCParser.InstanceMethodDeclarationContext ctx) {
        super.enterInstanceMethodDeclaration(ctx)
    }

    @Override
    void exitInstanceMethodDeclaration(ObjectiveCParser.InstanceMethodDeclarationContext ctx) {
        super.exitInstanceMethodDeclaration(ctx)
    }

    @Override
    void enterMethodDeclaration(ObjectiveCParser.MethodDeclarationContext ctx) {
        super.enterMethodDeclaration(ctx)
    }

    @Override
    void exitMethodDeclaration(ObjectiveCParser.MethodDeclarationContext ctx) {
        super.exitMethodDeclaration(ctx)
    }

    @Override
    void enterFunctionDeclaration(ObjectiveCParser.FunctionDeclarationContext ctx) {
        super.enterFunctionDeclaration(ctx)
    }

    @Override
    void exitFunctionDeclaration(ObjectiveCParser.FunctionDeclarationContext ctx) {
        super.exitFunctionDeclaration(ctx)
    }
}
