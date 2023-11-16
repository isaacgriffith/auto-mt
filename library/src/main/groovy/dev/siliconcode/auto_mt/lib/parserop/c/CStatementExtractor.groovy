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
package dev.siliconcode.auto_mt.lib.parserop.c


import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.parsers.c.CParser

class CStatementExtractor extends CAbstractExtractor implements CFGStatementHandler {

    CStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        super.enterFunctionDefinition(ctx)
    }

    @Override
    void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        super.exitFunctionDefinition(ctx)
    }

    @Override
    void enterStatement(CParser.StatementContext ctx) {
        super.enterStatement(ctx)
    }

    @Override
    void exitStatement(CParser.StatementContext ctx) {
        super.exitStatement(ctx)
    }

    @Override
    void enterLabeledStatement(CParser.LabeledStatementContext ctx) {
        super.enterLabeledStatement(ctx)
    }

    @Override
    void exitLabeledStatement(CParser.LabeledStatementContext ctx) {
        super.exitLabeledStatement(ctx)
    }

    @Override
    void enterCompoundStatement(CParser.CompoundStatementContext ctx) {
        super.enterCompoundStatement(ctx)
    }

    @Override
    void exitCompoundStatement(CParser.CompoundStatementContext ctx) {
        super.exitCompoundStatement(ctx)
    }

    @Override
    void enterExpressionStatement(CParser.ExpressionStatementContext ctx) {
        super.enterExpressionStatement(ctx)
    }

    @Override
    void exitExpressionStatement(CParser.ExpressionStatementContext ctx) {
        super.exitExpressionStatement(ctx)
    }

    @Override
    void enterSelectionStatement(CParser.SelectionStatementContext ctx) {
        super.enterSelectionStatement(ctx)
    }

    @Override
    void exitSelectionStatement(CParser.SelectionStatementContext ctx) {
        super.exitSelectionStatement(ctx)
    }

    @Override
    void enterIterationStatement(CParser.IterationStatementContext ctx) {
        super.enterIterationStatement(ctx)
    }

    @Override
    void exitIterationStatement(CParser.IterationStatementContext ctx) {
        super.exitIterationStatement(ctx)
    }

    @Override
    void enterJumpStatement(CParser.JumpStatementContext ctx) {
        super.enterJumpStatement(ctx)
    }

    @Override
    void exitJumpStatement(CParser.JumpStatementContext ctx) {
        super.exitJumpStatement(ctx)
    }
}
