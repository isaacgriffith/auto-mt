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
package dev.siliconcode.auto_mt.lib.parserop.go


import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.parsers.go.GoParser

class GoStatementExtractor extends GoAbstractExtractor implements CFGStatementHandler {

    GoStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterFunctionDecl(GoParser.FunctionDeclContext ctx) {
        super.enterFunctionDecl(ctx)
    }

    @Override
    void exitFunctionDecl(GoParser.FunctionDeclContext ctx) {
        super.exitFunctionDecl(ctx)
    }

    @Override
    void enterStatementList(GoParser.StatementListContext ctx) {
        super.enterStatementList(ctx)
    }

    @Override
    void exitStatementList(GoParser.StatementListContext ctx) {
        super.exitStatementList(ctx)
    }

    @Override
    void enterStatement(GoParser.StatementContext ctx) {
        super.enterStatement(ctx)
    }

    @Override
    void exitStatement(GoParser.StatementContext ctx) {
        super.exitStatement(ctx)
    }

    @Override
    void enterSimpleStmt(GoParser.SimpleStmtContext ctx) {
        super.enterSimpleStmt(ctx)
    }

    @Override
    void exitSimpleStmt(GoParser.SimpleStmtContext ctx) {
        super.exitSimpleStmt(ctx)
    }

    @Override
    void enterExpressionStmt(GoParser.ExpressionStmtContext ctx) {
        super.enterExpressionStmt(ctx)
    }

    @Override
    void exitExpressionStmt(GoParser.ExpressionStmtContext ctx) {
        super.exitExpressionStmt(ctx)
    }

    @Override
    void enterSendStmt(GoParser.SendStmtContext ctx) {
        super.enterSendStmt(ctx)
    }

    @Override
    void exitSendStmt(GoParser.SendStmtContext ctx) {
        super.exitSendStmt(ctx)
    }

    @Override
    void enterIncDecStmt(GoParser.IncDecStmtContext ctx) {
        super.enterIncDecStmt(ctx)
    }

    @Override
    void exitIncDecStmt(GoParser.IncDecStmtContext ctx) {
        super.exitIncDecStmt(ctx)
    }

    @Override
    void enterLabeledStmt(GoParser.LabeledStmtContext ctx) {
        super.enterLabeledStmt(ctx)
    }

    @Override
    void exitLabeledStmt(GoParser.LabeledStmtContext ctx) {
        super.exitLabeledStmt(ctx)
    }

    @Override
    void enterReturnStmt(GoParser.ReturnStmtContext ctx) {
        super.enterReturnStmt(ctx)
    }

    @Override
    void exitReturnStmt(GoParser.ReturnStmtContext ctx) {
        super.exitReturnStmt(ctx)
    }

    @Override
    void enterBreakStmt(GoParser.BreakStmtContext ctx) {
        super.enterBreakStmt(ctx)
    }

    @Override
    void exitBreakStmt(GoParser.BreakStmtContext ctx) {
        super.exitBreakStmt(ctx)
    }

    @Override
    void enterContinueStmt(GoParser.ContinueStmtContext ctx) {
        super.enterContinueStmt(ctx)
    }

    @Override
    void exitContinueStmt(GoParser.ContinueStmtContext ctx) {
        super.exitContinueStmt(ctx)
    }

    @Override
    void enterGotoStmt(GoParser.GotoStmtContext ctx) {
        super.enterGotoStmt(ctx)
    }

    @Override
    void exitGotoStmt(GoParser.GotoStmtContext ctx) {
        super.exitGotoStmt(ctx)
    }

    @Override
    void enterFallthroughStmt(GoParser.FallthroughStmtContext ctx) {
        super.enterFallthroughStmt(ctx)
    }

    @Override
    void exitFallthroughStmt(GoParser.FallthroughStmtContext ctx) {
        super.exitFallthroughStmt(ctx)
    }

    @Override
    void enterDeferStmt(GoParser.DeferStmtContext ctx) {
        super.enterDeferStmt(ctx)
    }

    @Override
    void exitDeferStmt(GoParser.DeferStmtContext ctx) {
        super.exitDeferStmt(ctx)
    }

    @Override
    void enterIfStmt(GoParser.IfStmtContext ctx) {
        super.enterIfStmt(ctx)
    }

    @Override
    void exitIfStmt(GoParser.IfStmtContext ctx) {
        super.exitIfStmt(ctx)
    }

    @Override
    void enterSwitchStmt(GoParser.SwitchStmtContext ctx) {
        super.enterSwitchStmt(ctx)
    }

    @Override
    void exitSwitchStmt(GoParser.SwitchStmtContext ctx) {
        super.exitSwitchStmt(ctx)
    }

    @Override
    void enterExprSwitchStmt(GoParser.ExprSwitchStmtContext ctx) {
        super.enterExprSwitchStmt(ctx)
    }

    @Override
    void exitExprSwitchStmt(GoParser.ExprSwitchStmtContext ctx) {
        super.exitExprSwitchStmt(ctx)
    }

    @Override
    void enterTypeSwitchStmt(GoParser.TypeSwitchStmtContext ctx) {
        super.enterTypeSwitchStmt(ctx)
    }

    @Override
    void exitTypeSwitchStmt(GoParser.TypeSwitchStmtContext ctx) {
        super.exitTypeSwitchStmt(ctx)
    }

    @Override
    void enterSelectStmt(GoParser.SelectStmtContext ctx) {
        super.enterSelectStmt(ctx)
    }

    @Override
    void exitSelectStmt(GoParser.SelectStmtContext ctx) {
        super.exitSelectStmt(ctx)
    }

    @Override
    void enterRecvStmt(GoParser.RecvStmtContext ctx) {
        super.enterRecvStmt(ctx)
    }

    @Override
    void exitRecvStmt(GoParser.RecvStmtContext ctx) {
        super.exitRecvStmt(ctx)
    }

    @Override
    void enterForStmt(GoParser.ForStmtContext ctx) {
        super.enterForStmt(ctx)
    }

    @Override
    void exitForStmt(GoParser.ForStmtContext ctx) {
        super.exitForStmt(ctx)
    }

    @Override
    void enterGoStmt(GoParser.GoStmtContext ctx) {
        super.enterGoStmt(ctx)
    }

    @Override
    void exitGoStmt(GoParser.GoStmtContext ctx) {
        super.exitGoStmt(ctx)
    }
}
