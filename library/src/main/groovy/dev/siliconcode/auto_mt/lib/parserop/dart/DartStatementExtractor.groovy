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
import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.parsers.dart.Dart2Parser

class DartStatementExtractor extends DartAbstractExtractor implements CFGStatementHandler {

    DartStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterLocalFunctionDeclaration(Dart2Parser.LocalFunctionDeclarationContext ctx) {
        super.enterLocalFunctionDeclaration(ctx)
    }

    @Override
    void exitLocalFunctionDeclaration(Dart2Parser.LocalFunctionDeclarationContext ctx) {
        super.exitLocalFunctionDeclaration(ctx)
    }

    @Override
    void enterAssertStatement(Dart2Parser.AssertStatementContext ctx) {
        super.enterAssertStatement(ctx)
    }

    @Override
    void exitAssertStatement(Dart2Parser.AssertStatementContext ctx) {
        super.exitAssertStatement(ctx)
    }

    @Override
    void enterBreakStatement(Dart2Parser.BreakStatementContext ctx) {
        super.enterBreakStatement(ctx)
    }

    @Override
    void exitBreakStatement(Dart2Parser.BreakStatementContext ctx) {
        super.exitBreakStatement(ctx)
    }

    @Override
    void enterContinueStatement(Dart2Parser.ContinueStatementContext ctx) {
        super.enterContinueStatement(ctx)
    }

    @Override
    void exitContinueStatement(Dart2Parser.ContinueStatementContext ctx) {
        super.exitContinueStatement(ctx)
    }

    @Override
    void enterDoStatement(Dart2Parser.DoStatementContext ctx) {
        super.enterDoStatement(ctx)
    }

    @Override
    void exitDoStatement(Dart2Parser.DoStatementContext ctx) {
        super.exitDoStatement(ctx)
    }

    @Override
    void enterExpressionStatement(Dart2Parser.ExpressionStatementContext ctx) {
        super.enterExpressionStatement(ctx)
    }

    @Override
    void exitExpressionStatement(Dart2Parser.ExpressionStatementContext ctx) {
        super.exitExpressionStatement(ctx)
    }

    @Override
    void enterForInitializerStatement(Dart2Parser.ForInitializerStatementContext ctx) {
        super.enterForInitializerStatement(ctx)
    }

    @Override
    void exitForInitializerStatement(Dart2Parser.ForInitializerStatementContext ctx) {
        super.exitForInitializerStatement(ctx)
    }

    @Override
    void enterForStatement(Dart2Parser.ForStatementContext ctx) {
        super.enterForStatement(ctx)
    }

    @Override
    void exitForStatement(Dart2Parser.ForStatementContext ctx) {
        super.exitForStatement(ctx)
    }

    @Override
    void enterIfStatement(Dart2Parser.IfStatementContext ctx) {
        super.enterIfStatement(ctx)
    }

    @Override
    void exitIfStatement(Dart2Parser.IfStatementContext ctx) {
        super.exitIfStatement(ctx)
    }

    @Override
    void enterNonLabelledStatement(Dart2Parser.NonLabelledStatementContext ctx) {
        super.enterNonLabelledStatement(ctx)
    }

    @Override
    void exitNonLabelledStatement(Dart2Parser.NonLabelledStatementContext ctx) {
        super.exitNonLabelledStatement(ctx)
    }

    @Override
    void enterRethrowStatement(Dart2Parser.RethrowStatementContext ctx) {
        super.enterRethrowStatement(ctx)
    }

    @Override
    void exitRethrowStatement(Dart2Parser.RethrowStatementContext ctx) {
        super.exitRethrowStatement(ctx)
    }

    @Override
    void enterReturnStatement(Dart2Parser.ReturnStatementContext ctx) {
        super.enterReturnStatement(ctx)
    }

    @Override
    void exitReturnStatement(Dart2Parser.ReturnStatementContext ctx) {
        super.exitReturnStatement(ctx)
    }

    @Override
    void enterStatement(Dart2Parser.StatementContext ctx) {
        super.enterStatement(ctx)
    }

    @Override
    void exitStatement(Dart2Parser.StatementContext ctx) {
        super.exitStatement(ctx)
    }

    @Override
    void enterStatements(Dart2Parser.StatementsContext ctx) {
        super.enterStatements(ctx)
    }

    @Override
    void exitStatements(Dart2Parser.StatementsContext ctx) {
        super.exitStatements(ctx)
    }

    @Override
    void enterSwitchStatement(Dart2Parser.SwitchStatementContext ctx) {
        super.enterSwitchStatement(ctx)
    }

    @Override
    void exitSwitchStatement(Dart2Parser.SwitchStatementContext ctx) {
        super.exitSwitchStatement(ctx)
    }

    @Override
    void enterTryStatement(Dart2Parser.TryStatementContext ctx) {
        super.enterTryStatement(ctx)
    }

    @Override
    void exitTryStatement(Dart2Parser.TryStatementContext ctx) {
        super.exitTryStatement(ctx)
    }

    @Override
    void enterWhileStatement(Dart2Parser.WhileStatementContext ctx) {
        super.enterWhileStatement(ctx)
    }

    @Override
    void exitWhileStatement(Dart2Parser.WhileStatementContext ctx) {
        super.exitWhileStatement(ctx)
    }

    @Override
    void enterYieldEachStatement(Dart2Parser.YieldEachStatementContext ctx) {
        super.enterYieldEachStatement(ctx)
    }

    @Override
    void exitYieldEachStatement(Dart2Parser.YieldEachStatementContext ctx) {
        super.exitYieldEachStatement(ctx)
    }

    @Override
    void enterYieldStatement(Dart2Parser.YieldStatementContext ctx) {
        super.enterYieldStatement(ctx)
    }

    @Override
    void exitYieldStatement(Dart2Parser.YieldStatementContext ctx) {
        super.exitYieldStatement(ctx)
    }
}
