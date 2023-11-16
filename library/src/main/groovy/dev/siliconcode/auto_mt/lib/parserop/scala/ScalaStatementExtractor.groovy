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

import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.scala.ScalaParser

class ScalaStatementExtractor extends ScalaAbstractExtractor implements CFGStatementHandler {

    ScalaStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterFunDcl(ScalaParser.FunDclContext ctx) {
        super.enterFunDcl(ctx)
    }

    @Override
    void exitFunDcl(ScalaParser.FunDclContext ctx) {
        super.exitFunDcl(ctx)
    }

    @Override
    void enterRefineStat(ScalaParser.RefineStatContext ctx) {
        super.enterRefineStat(ctx)
    }

    @Override
    void exitRefineStat(ScalaParser.RefineStatContext ctx) {
        super.exitRefineStat(ctx)
    }

    @Override
    void enterBlockStat(ScalaParser.BlockStatContext ctx) {
        super.enterBlockStat(ctx)
    }

    @Override
    void exitBlockStat(ScalaParser.BlockStatContext ctx) {
        super.exitBlockStat(ctx)
    }

    @Override
    void enterTemplateStat(ScalaParser.TemplateStatContext ctx) {
        super.enterTemplateStat(ctx)
    }

    @Override
    void exitTemplateStat(ScalaParser.TemplateStatContext ctx) {
        super.exitTemplateStat(ctx)
    }


}
