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
package dev.siliconcode.auto_mt.lib.parserop.java

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.java.Java20Parser
import dev.siliconcode.auto_mt.parsers.java.Java20ParserBaseListener

class JavaFileAndTypeExtractor extends Java20ParserBaseListener {

    ModelBuilder builder
    boolean inTypeDecl = false

    JavaFileAndTypeExtractor(ModelBuilder builder) {
        this.builder = builder
    }

    @Override
    void enterTopLevelClassOrInterfaceDeclaration(Java20Parser.TopLevelClassOrInterfaceDeclarationContext ctx) {
        super.enterTopLevelClassOrInterfaceDeclaration(ctx)
    }

    @Override
    void exitTopLevelClassOrInterfaceDeclaration(Java20Parser.TopLevelClassOrInterfaceDeclarationContext ctx) {
        super.exitTopLevelClassOrInterfaceDeclaration(ctx)
    }

    @Override
    void enterClassDeclaration(Java20Parser.ClassDeclarationContext ctx) {
        super.enterClassDeclaration(ctx)
    }

    @Override
    void exitClassDeclaration(Java20Parser.ClassDeclarationContext ctx) {
        super.exitClassDeclaration(ctx)
    }

    @Override
    void enterNormalClassDeclaration(Java20Parser.NormalClassDeclarationContext ctx) {
        super.enterNormalClassDeclaration(ctx)
    }

    @Override
    void exitNormalClassDeclaration(Java20Parser.NormalClassDeclarationContext ctx) {
        super.exitNormalClassDeclaration(ctx)
    }

    @Override
    void enterEnumDeclaration(Java20Parser.EnumDeclarationContext ctx) {
        super.enterEnumDeclaration(ctx)
    }

    @Override
    void exitEnumDeclaration(Java20Parser.EnumDeclarationContext ctx) {
        super.exitEnumDeclaration(ctx)
    }

    @Override
    void enterRecordDeclaration(Java20Parser.RecordDeclarationContext ctx) {
        super.enterRecordDeclaration(ctx)
    }

    @Override
    void exitRecordDeclaration(Java20Parser.RecordDeclarationContext ctx) {
        super.exitRecordDeclaration(ctx)
    }

    @Override
    void enterInterfaceDeclaration(Java20Parser.InterfaceDeclarationContext ctx) {
        super.enterInterfaceDeclaration(ctx)
    }

    @Override
    void exitInterfaceDeclaration(Java20Parser.InterfaceDeclarationContext ctx) {
        super.exitInterfaceDeclaration(ctx)
    }

    @Override
    void enterNormalInterfaceDeclaration(Java20Parser.NormalInterfaceDeclarationContext ctx) {
        super.enterNormalInterfaceDeclaration(ctx)
    }

    @Override
    void exitNormalInterfaceDeclaration(Java20Parser.NormalInterfaceDeclarationContext ctx) {
        super.exitNormalInterfaceDeclaration(ctx)
    }

    @Override
    void enterAnnotationInterfaceDeclaration(Java20Parser.AnnotationInterfaceDeclarationContext ctx) {
        super.enterAnnotationInterfaceDeclaration(ctx)
    }

    @Override
    void exitAnnotationInterfaceDeclaration(Java20Parser.AnnotationInterfaceDeclarationContext ctx) {
        super.exitAnnotationInterfaceDeclaration(ctx)
    }

    @Override
    void enterLocalClassOrInterfaceDeclaration(Java20Parser.LocalClassOrInterfaceDeclarationContext ctx) {
        super.enterLocalClassOrInterfaceDeclaration(ctx)
    }

    @Override
    void exitLocalClassOrInterfaceDeclaration(Java20Parser.LocalClassOrInterfaceDeclarationContext ctx) {
        super.exitLocalClassOrInterfaceDeclaration(ctx)
    }
}
