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
package dev.siliconcode.auto_mt.lib.parserop.php

import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.php.PhpParser

class PHPStatementExtractor extends PHPAbstractExtractor implements CFGStatementHandler {

    PHPStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
        super.enterFunctionDeclaration(ctx)
    }

    @Override
    void exitFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
        super.exitFunctionDeclaration(ctx)
    }

    @Override
    void enterTopStatement(PhpParser.TopStatementContext ctx) {
        super.enterTopStatement(ctx)
    }

    @Override
    void exitTopStatement(PhpParser.TopStatementContext ctx) {
        super.exitTopStatement(ctx)
    }

    @Override
    void enterInnerStatementList(PhpParser.InnerStatementListContext ctx) {
        super.enterInnerStatementList(ctx)
    }

    @Override
    void exitInnerStatementList(PhpParser.InnerStatementListContext ctx) {
        super.exitInnerStatementList(ctx)
    }

    @Override
    void enterInnerStatement(PhpParser.InnerStatementContext ctx) {
        super.enterInnerStatement(ctx)
    }

    @Override
    void exitInnerStatement(PhpParser.InnerStatementContext ctx) {
        super.exitInnerStatement(ctx)
    }

    @Override
    void enterStatement(PhpParser.StatementContext ctx) {
        super.enterStatement(ctx)
    }

    @Override
    void exitStatement(PhpParser.StatementContext ctx) {
        super.exitStatement(ctx)
    }

    @Override
    void enterEmptyStatement_(PhpParser.EmptyStatement_Context ctx) {
        super.enterEmptyStatement_(ctx)
    }

    @Override
    void exitEmptyStatement_(PhpParser.EmptyStatement_Context ctx) {
        super.exitEmptyStatement_(ctx)
    }

    @Override
    void enterBlockStatement(PhpParser.BlockStatementContext ctx) {
        super.enterBlockStatement(ctx)
    }

    @Override
    void exitBlockStatement(PhpParser.BlockStatementContext ctx) {
        super.exitBlockStatement(ctx)
    }

    @Override
    void enterIfStatement(PhpParser.IfStatementContext ctx) {
        super.enterIfStatement(ctx)
    }

    @Override
    void exitIfStatement(PhpParser.IfStatementContext ctx) {
        super.exitIfStatement(ctx)
    }

    @Override
    void enterElseIfStatement(PhpParser.ElseIfStatementContext ctx) {
        super.enterElseIfStatement(ctx)
    }

    @Override
    void exitElseIfStatement(PhpParser.ElseIfStatementContext ctx) {
        super.exitElseIfStatement(ctx)
    }

    @Override
    void enterElseIfColonStatement(PhpParser.ElseIfColonStatementContext ctx) {
        super.enterElseIfColonStatement(ctx)
    }

    @Override
    void exitElseIfColonStatement(PhpParser.ElseIfColonStatementContext ctx) {
        super.exitElseIfColonStatement(ctx)
    }

    @Override
    void enterElseStatement(PhpParser.ElseStatementContext ctx) {
        super.enterElseStatement(ctx)
    }

    @Override
    void exitElseStatement(PhpParser.ElseStatementContext ctx) {
        super.exitElseStatement(ctx)
    }

    @Override
    void enterElseColonStatement(PhpParser.ElseColonStatementContext ctx) {
        super.enterElseColonStatement(ctx)
    }

    @Override
    void exitElseColonStatement(PhpParser.ElseColonStatementContext ctx) {
        super.exitElseColonStatement(ctx)
    }

    @Override
    void enterWhileStatement(PhpParser.WhileStatementContext ctx) {
        super.enterWhileStatement(ctx)
    }

    @Override
    void exitWhileStatement(PhpParser.WhileStatementContext ctx) {
        super.exitWhileStatement(ctx)
    }

    @Override
    void enterDoWhileStatement(PhpParser.DoWhileStatementContext ctx) {
        super.enterDoWhileStatement(ctx)
    }

    @Override
    void exitDoWhileStatement(PhpParser.DoWhileStatementContext ctx) {
        super.exitDoWhileStatement(ctx)
    }

    @Override
    void enterForStatement(PhpParser.ForStatementContext ctx) {
        super.enterForStatement(ctx)
    }

    @Override
    void exitForStatement(PhpParser.ForStatementContext ctx) {
        super.exitForStatement(ctx)
    }

    @Override
    void enterSwitchStatement(PhpParser.SwitchStatementContext ctx) {
        super.enterSwitchStatement(ctx)
    }

    @Override
    void exitSwitchStatement(PhpParser.SwitchStatementContext ctx) {
        super.exitSwitchStatement(ctx)
    }

    @Override
    void enterBreakStatement(PhpParser.BreakStatementContext ctx) {
        super.enterBreakStatement(ctx)
    }

    @Override
    void exitBreakStatement(PhpParser.BreakStatementContext ctx) {
        super.exitBreakStatement(ctx)
    }

    @Override
    void enterContinueStatement(PhpParser.ContinueStatementContext ctx) {
        super.enterContinueStatement(ctx)
    }

    @Override
    void exitContinueStatement(PhpParser.ContinueStatementContext ctx) {
        super.exitContinueStatement(ctx)
    }

    @Override
    void enterReturnStatement(PhpParser.ReturnStatementContext ctx) {
        super.enterReturnStatement(ctx)
    }

    @Override
    void exitReturnStatement(PhpParser.ReturnStatementContext ctx) {
        super.exitReturnStatement(ctx)
    }

    @Override
    void enterExpressionStatement(PhpParser.ExpressionStatementContext ctx) {
        super.enterExpressionStatement(ctx)
    }

    @Override
    void exitExpressionStatement(PhpParser.ExpressionStatementContext ctx) {
        super.exitExpressionStatement(ctx)
    }

    @Override
    void enterUnsetStatement(PhpParser.UnsetStatementContext ctx) {
        super.enterUnsetStatement(ctx)
    }

    @Override
    void exitUnsetStatement(PhpParser.UnsetStatementContext ctx) {
        super.exitUnsetStatement(ctx)
    }

    @Override
    void enterForeachStatement(PhpParser.ForeachStatementContext ctx) {
        super.enterForeachStatement(ctx)
    }

    @Override
    void exitForeachStatement(PhpParser.ForeachStatementContext ctx) {
        super.exitForeachStatement(ctx)
    }

    @Override
    void enterFinallyStatement(PhpParser.FinallyStatementContext ctx) {
        super.enterFinallyStatement(ctx)
    }

    @Override
    void exitFinallyStatement(PhpParser.FinallyStatementContext ctx) {
        super.exitFinallyStatement(ctx)
    }

    @Override
    void enterThrowStatement(PhpParser.ThrowStatementContext ctx) {
        super.enterThrowStatement(ctx)
    }

    @Override
    void exitThrowStatement(PhpParser.ThrowStatementContext ctx) {
        super.exitThrowStatement(ctx)
    }

    @Override
    void enterGotoStatement(PhpParser.GotoStatementContext ctx) {
        super.enterGotoStatement(ctx)
    }

    @Override
    void exitGotoStatement(PhpParser.GotoStatementContext ctx) {
        super.exitGotoStatement(ctx)
    }

    @Override
    void enterDeclareStatement(PhpParser.DeclareStatementContext ctx) {
        super.enterDeclareStatement(ctx)
    }

    @Override
    void exitDeclareStatement(PhpParser.DeclareStatementContext ctx) {
        super.exitDeclareStatement(ctx)
    }

    @Override
    void enterInlineHtmlStatement(PhpParser.InlineHtmlStatementContext ctx) {
        super.enterInlineHtmlStatement(ctx)
    }

    @Override
    void exitInlineHtmlStatement(PhpParser.InlineHtmlStatementContext ctx) {
        super.exitInlineHtmlStatement(ctx)
    }

    @Override
    void enterGlobalStatement(PhpParser.GlobalStatementContext ctx) {
        super.enterGlobalStatement(ctx)
    }

    @Override
    void exitGlobalStatement(PhpParser.GlobalStatementContext ctx) {
        super.exitGlobalStatement(ctx)
    }

    @Override
    void enterEchoStatement(PhpParser.EchoStatementContext ctx) {
        super.enterEchoStatement(ctx)
    }

    @Override
    void exitEchoStatement(PhpParser.EchoStatementContext ctx) {
        super.exitEchoStatement(ctx)
    }

    @Override
    void enterStaticVariableStatement(PhpParser.StaticVariableStatementContext ctx) {
        super.enterStaticVariableStatement(ctx)
    }

    @Override
    void exitStaticVariableStatement(PhpParser.StaticVariableStatementContext ctx) {
        super.exitStaticVariableStatement(ctx)
    }

    @Override
    void enterClassStatement(PhpParser.ClassStatementContext ctx) {
        super.enterClassStatement(ctx)
    }

    @Override
    void exitClassStatement(PhpParser.ClassStatementContext ctx) {
        super.exitClassStatement(ctx)
    }

    @Override
    void enterTraitAdaptationStatement(PhpParser.TraitAdaptationStatementContext ctx) {
        super.enterTraitAdaptationStatement(ctx)
    }

    @Override
    void exitTraitAdaptationStatement(PhpParser.TraitAdaptationStatementContext ctx) {
        super.exitTraitAdaptationStatement(ctx)
    }
}
