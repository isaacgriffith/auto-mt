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
package dev.siliconcode.auto_mt.lib.parserop.kotlin

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.parsers.kotlin.KotlinParser

class KotlinStatementExtractor extends KotlinAbstractExtractor implements CFGStatementHandler {

    KotlinStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterFunctionDeclaration(KotlinParser.FunctionDeclarationContext ctx) {
        super.enterFunctionDeclaration(ctx)
    }

    @Override
    void exitFunctionDeclaration(KotlinParser.FunctionDeclarationContext ctx) {
        super.exitFunctionDeclaration(ctx)
    }

    @Override
    void enterPropertyDeclaration(KotlinParser.PropertyDeclarationContext ctx) {
        super.enterPropertyDeclaration(ctx)
    }

    @Override
    void exitPropertyDeclaration(KotlinParser.PropertyDeclarationContext ctx) {
        super.exitPropertyDeclaration(ctx)
    }

    @Override
    void enterBlockLevelExpression(KotlinParser.BlockLevelExpressionContext ctx) {
        super.enterBlockLevelExpression(ctx)
    }

    @Override
    void exitBlockLevelExpression(KotlinParser.BlockLevelExpressionContext ctx) {
        super.exitBlockLevelExpression(ctx)
    }

    @Override
    void enterExpression(KotlinParser.ExpressionContext ctx) {
        super.enterExpression(ctx)
    }

    @Override
    void exitExpression(KotlinParser.ExpressionContext ctx) {
        super.exitExpression(ctx)
    }

    @Override
    void exitElvisExpression(KotlinParser.ElvisExpressionContext ctx) {
        super.exitElvisExpression(ctx)
    }

    @Override
    void enterRangeExpression(KotlinParser.RangeExpressionContext ctx) {
        super.enterRangeExpression(ctx)
    }

    @Override
    void exitRangeExpression(KotlinParser.RangeExpressionContext ctx) {
        super.exitRangeExpression(ctx)
    }

    @Override
    void enterAdditiveExpression(KotlinParser.AdditiveExpressionContext ctx) {
        super.enterAdditiveExpression(ctx)
    }

    @Override
    void exitAdditiveExpression(KotlinParser.AdditiveExpressionContext ctx) {
        super.exitAdditiveExpression(ctx)
    }

    @Override
    void enterMultiplicativeExpression(KotlinParser.MultiplicativeExpressionContext ctx) {
        super.enterMultiplicativeExpression(ctx)
    }

    @Override
    void exitMultiplicativeExpression(KotlinParser.MultiplicativeExpressionContext ctx) {
        super.exitMultiplicativeExpression(ctx)
    }

    @Override
    void enterPrefixUnaryExpression(KotlinParser.PrefixUnaryExpressionContext ctx) {
        super.enterPrefixUnaryExpression(ctx)
    }

    @Override
    void exitPrefixUnaryExpression(KotlinParser.PrefixUnaryExpressionContext ctx) {
        super.exitPrefixUnaryExpression(ctx)
    }

    @Override
    void enterPostfixUnaryExpression(KotlinParser.PostfixUnaryExpressionContext ctx) {
        super.enterPostfixUnaryExpression(ctx)
    }

    @Override
    void exitPostfixUnaryExpression(KotlinParser.PostfixUnaryExpressionContext ctx) {
        super.exitPostfixUnaryExpression(ctx)
    }

    @Override
    void enterAtomicExpression(KotlinParser.AtomicExpressionContext ctx) {
        super.enterAtomicExpression(ctx)
    }

    @Override
    void exitAtomicExpression(KotlinParser.AtomicExpressionContext ctx) {
        super.exitAtomicExpression(ctx)
    }

    @Override
    void enterParenthesizedExpression(KotlinParser.ParenthesizedExpressionContext ctx) {
        super.enterParenthesizedExpression(ctx)
    }

    @Override
    void exitParenthesizedExpression(KotlinParser.ParenthesizedExpressionContext ctx) {
        super.exitParenthesizedExpression(ctx)
    }

    @Override
    void enterLineStringExpression(KotlinParser.LineStringExpressionContext ctx) {
        super.enterLineStringExpression(ctx)
    }

    @Override
    void exitLineStringExpression(KotlinParser.LineStringExpressionContext ctx) {
        super.exitLineStringExpression(ctx)
    }

    @Override
    void enterMultiLineStringExpression(KotlinParser.MultiLineStringExpressionContext ctx) {
        super.enterMultiLineStringExpression(ctx)
    }

    @Override
    void exitMultiLineStringExpression(KotlinParser.MultiLineStringExpressionContext ctx) {
        super.exitMultiLineStringExpression(ctx)
    }

    @Override
    void enterThisExpression(KotlinParser.ThisExpressionContext ctx) {
        super.enterThisExpression(ctx)
    }

    @Override
    void exitThisExpression(KotlinParser.ThisExpressionContext ctx) {
        super.exitThisExpression(ctx)
    }

    @Override
    void enterSuperExpression(KotlinParser.SuperExpressionContext ctx) {
        super.enterSuperExpression(ctx)
    }

    @Override
    void exitSuperExpression(KotlinParser.SuperExpressionContext ctx) {
        super.exitSuperExpression(ctx)
    }

    @Override
    void enterConditionalExpression(KotlinParser.ConditionalExpressionContext ctx) {
        super.enterConditionalExpression(ctx)
    }

    @Override
    void exitConditionalExpression(KotlinParser.ConditionalExpressionContext ctx) {
        super.exitConditionalExpression(ctx)
    }

    @Override
    void enterIfExpression(KotlinParser.IfExpressionContext ctx) {
        super.enterIfExpression(ctx)
    }

    @Override
    void exitIfExpression(KotlinParser.IfExpressionContext ctx) {
        super.exitIfExpression(ctx)
    }

    @Override
    void enterWhenExpression(KotlinParser.WhenExpressionContext ctx) {
        super.enterWhenExpression(ctx)
    }

    @Override
    void exitWhenExpression(KotlinParser.WhenExpressionContext ctx) {
        super.exitWhenExpression(ctx)
    }

    @Override
    void enterTryExpression(KotlinParser.TryExpressionContext ctx) {
        super.enterTryExpression(ctx)
    }

    @Override
    void exitTryExpression(KotlinParser.TryExpressionContext ctx) {
        super.exitTryExpression(ctx)
    }

    @Override
    void enterLoopExpression(KotlinParser.LoopExpressionContext ctx) {
        super.enterLoopExpression(ctx)
    }

    @Override
    void exitLoopExpression(KotlinParser.LoopExpressionContext ctx) {
        super.exitLoopExpression(ctx)
    }

    @Override
    void enterForExpression(KotlinParser.ForExpressionContext ctx) {
        super.enterForExpression(ctx)
    }

    @Override
    void exitForExpression(KotlinParser.ForExpressionContext ctx) {
        super.exitForExpression(ctx)
    }

    @Override
    void enterWhileExpression(KotlinParser.WhileExpressionContext ctx) {
        super.enterWhileExpression(ctx)
    }

    @Override
    void exitWhileExpression(KotlinParser.WhileExpressionContext ctx) {
        super.exitWhileExpression(ctx)
    }

    @Override
    void enterDoWhileExpression(KotlinParser.DoWhileExpressionContext ctx) {
        super.enterDoWhileExpression(ctx)
    }

    @Override
    void exitDoWhileExpression(KotlinParser.DoWhileExpressionContext ctx) {
        super.exitDoWhileExpression(ctx)
    }

    @Override
    void enterJumpExpression(KotlinParser.JumpExpressionContext ctx) {
        super.enterJumpExpression(ctx)
    }

    @Override
    void exitJumpExpression(KotlinParser.JumpExpressionContext ctx) {
        super.exitJumpExpression(ctx)
    }
}
