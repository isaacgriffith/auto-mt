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
package dev.siliconcode.auto_mt.lib.parserop.scala

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.scala.ScalaBaseListener
import dev.siliconcode.auto_mt.parsers.scala.ScalaParser

abstract class ScalaAbstractExtractor extends ScalaBaseListener {

    private ModelBuilder modelBuilder

    ScalaAbstractExtractor(ModelBuilder builder) {
        this.modelBuilder = builder
    }

    @Override
    void enterPatDef(ScalaParser.PatDefContext ctx) {
        super.enterPatDef(ctx)
    }

    @Override
    void exitPatDef(ScalaParser.PatDefContext ctx) {
        super.exitPatDef(ctx)
    }

    @Override
    void enterTypeDef(ScalaParser.TypeDefContext ctx) {
        super.enterTypeDef(ctx)
    }

    @Override
    void exitTypeDef(ScalaParser.TypeDefContext ctx) {
        super.exitTypeDef(ctx)
    }

    @Override
    void enterTmplDef(ScalaParser.TmplDefContext ctx) {
        super.enterTmplDef(ctx)
    }

    @Override
    void exitTmplDef(ScalaParser.TmplDefContext ctx) {
        super.exitTmplDef(ctx)
    }

    @Override
    void enterClassDef(ScalaParser.ClassDefContext ctx) {
        super.enterClassDef(ctx)
    }

    @Override
    void exitClassDef(ScalaParser.ClassDefContext ctx) {
        super.exitClassDef(ctx)
    }

    @Override
    void enterTraitDef(ScalaParser.TraitDefContext ctx) {
        super.enterTraitDef(ctx)
    }

    @Override
    void exitTraitDef(ScalaParser.TraitDefContext ctx) {
        super.exitTraitDef(ctx)
    }

    @Override
    void enterObjectDef(ScalaParser.ObjectDefContext ctx) {
        super.enterObjectDef(ctx)
    }

    @Override
    void exitObjectDef(ScalaParser.ObjectDefContext ctx) {
        super.exitObjectDef(ctx)
    }

    @Override
    void enterFunDcl(ScalaParser.FunDclContext ctx) {
        super.enterFunDcl(ctx)
    }

    @Override
    void exitFunDcl(ScalaParser.FunDclContext ctx) {
        super.exitFunDcl(ctx)
    }
}
