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
package dev.siliconcode.auto_mt.lib.parserop.js

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.parsers.js.JavaScriptParser

class JavaScriptStatementExtractor extends JavaScriptAbstractExtractor implements CFGStatementHandler {

    JavaScriptStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
        super.enterFunctionDeclaration(ctx)
    }

    @Override
    void exitFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
        super.exitFunctionDeclaration(ctx)
    }

    @Override
    void enterStatement(JavaScriptParser.StatementContext ctx) {
        super.enterStatement(ctx)
    }

    @Override
    void exitStatement(JavaScriptParser.StatementContext ctx) {
        super.exitStatement(ctx)
    }

    @Override
    void enterVariableStatement(JavaScriptParser.VariableStatementContext ctx) {
        super.enterVariableStatement(ctx)
    }

    @Override
    void exitVariableStatement(JavaScriptParser.VariableStatementContext ctx) {
        super.exitVariableStatement(ctx)
    }

    @Override
    void enterEmptyStatement_(JavaScriptParser.EmptyStatement_Context ctx) {
        super.enterEmptyStatement_(ctx)
    }

    @Override
    void exitEmptyStatement_(JavaScriptParser.EmptyStatement_Context ctx) {
        super.exitEmptyStatement_(ctx)
    }

    @Override
    void enterExpressionStatement(JavaScriptParser.ExpressionStatementContext ctx) {
        super.enterExpressionStatement(ctx)
    }

    @Override
    void exitExpressionStatement(JavaScriptParser.ExpressionStatementContext ctx) {
        super.exitExpressionStatement(ctx)
    }

    @Override
    void enterIfStatement(JavaScriptParser.IfStatementContext ctx) {
        super.enterIfStatement(ctx)
    }

    @Override
    void exitIfStatement(JavaScriptParser.IfStatementContext ctx) {
        super.exitIfStatement(ctx)
    }

    @Override
    void enterDoStatement(JavaScriptParser.DoStatementContext ctx) {
        super.enterDoStatement(ctx)
    }

    @Override
    void exitDoStatement(JavaScriptParser.DoStatementContext ctx) {
        super.exitDoStatement(ctx)
    }

    @Override
    void enterWhileStatement(JavaScriptParser.WhileStatementContext ctx) {
        super.enterWhileStatement(ctx)
    }

    @Override
    void exitWhileStatement(JavaScriptParser.WhileStatementContext ctx) {
        super.exitWhileStatement(ctx)
    }

    @Override
    void enterForStatement(JavaScriptParser.ForStatementContext ctx) {
        super.enterForStatement(ctx)
    }

    @Override
    void exitForStatement(JavaScriptParser.ForStatementContext ctx) {
        super.exitForStatement(ctx)
    }

    @Override
    void enterForInStatement(JavaScriptParser.ForInStatementContext ctx) {
        super.enterForInStatement(ctx)
    }

    @Override
    void exitForInStatement(JavaScriptParser.ForInStatementContext ctx) {
        super.exitForInStatement(ctx)
    }

    @Override
    void enterForOfStatement(JavaScriptParser.ForOfStatementContext ctx) {
        super.enterForOfStatement(ctx)
    }

    @Override
    void exitForOfStatement(JavaScriptParser.ForOfStatementContext ctx) {
        super.exitForOfStatement(ctx)
    }

    @Override
    void enterContinueStatement(JavaScriptParser.ContinueStatementContext ctx) {
        super.enterContinueStatement(ctx)
    }

    @Override
    void exitContinueStatement(JavaScriptParser.ContinueStatementContext ctx) {
        super.exitContinueStatement(ctx)
    }

    @Override
    void enterBreakStatement(JavaScriptParser.BreakStatementContext ctx) {
        super.enterBreakStatement(ctx)
    }

    @Override
    void exitBreakStatement(JavaScriptParser.BreakStatementContext ctx) {
        super.exitBreakStatement(ctx)
    }

    @Override
    void enterReturnStatement(JavaScriptParser.ReturnStatementContext ctx) {
        super.enterReturnStatement(ctx)
    }

    @Override
    void exitReturnStatement(JavaScriptParser.ReturnStatementContext ctx) {
        super.exitReturnStatement(ctx)
    }

    @Override
    void enterYieldStatement(JavaScriptParser.YieldStatementContext ctx) {
        super.enterYieldStatement(ctx)
    }

    @Override
    void exitYieldStatement(JavaScriptParser.YieldStatementContext ctx) {
        super.exitYieldStatement(ctx)
    }

    @Override
    void enterWithStatement(JavaScriptParser.WithStatementContext ctx) {
        super.enterWithStatement(ctx)
    }

    @Override
    void exitWithStatement(JavaScriptParser.WithStatementContext ctx) {
        super.exitWithStatement(ctx)
    }

    @Override
    void enterSwitchStatement(JavaScriptParser.SwitchStatementContext ctx) {
        super.enterSwitchStatement(ctx)
    }

    @Override
    void exitSwitchStatement(JavaScriptParser.SwitchStatementContext ctx) {
        super.exitSwitchStatement(ctx)
    }

    @Override
    void enterLabelledStatement(JavaScriptParser.LabelledStatementContext ctx) {
        super.enterLabelledStatement(ctx)
    }

    @Override
    void exitLabelledStatement(JavaScriptParser.LabelledStatementContext ctx) {
        super.exitLabelledStatement(ctx)
    }

    @Override
    void enterThrowStatement(JavaScriptParser.ThrowStatementContext ctx) {
        super.enterThrowStatement(ctx)
    }

    @Override
    void exitThrowStatement(JavaScriptParser.ThrowStatementContext ctx) {
        super.exitThrowStatement(ctx)
    }

    @Override
    void enterTryStatement(JavaScriptParser.TryStatementContext ctx) {
        super.enterTryStatement(ctx)
    }

    @Override
    void exitTryStatement(JavaScriptParser.TryStatementContext ctx) {
        super.exitTryStatement(ctx)
    }

    @Override
    void enterDebuggerStatement(JavaScriptParser.DebuggerStatementContext ctx) {
        super.enterDebuggerStatement(ctx)
    }

    @Override
    void exitDebuggerStatement(JavaScriptParser.DebuggerStatementContext ctx) {
        super.exitDebuggerStatement(ctx)
    }
}
