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
import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.parsers.java.Java20Parser

class JavaStatementExtractor extends JavaAbstractExtractor implements CFGStatementHandler {

    JavaStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterInstanceInitializer(Java20Parser.InstanceInitializerContext ctx) {
        startMethod();
        handleInitializer(ctx);
        super.enterInstanceInitializer(ctx)
    }

    @Override
    void exitInstanceInitializer(Java20Parser.InstanceInitializerContext ctx) {
        endMethod();
        modelBuilder.finishMethod();
        super.exitInstanceInitializer(ctx)
    }

    @Override
    void enterStaticInitializer(Java20Parser.StaticInitializerContext ctx) {
        startMehod();
        handleInitializer(ctx);
        super.enterStaticInitializer(ctx)
    }

    @Override
    void exitStaticInitializer(Java20Parser.StaticInitializerContext ctx) {
        endMethod();
        modelBuilder.finishMethod();
        super.exitStaticInitializer(ctx)
    }

    @Override
    void enterMethodDeclaration(Java20Parser.MethodDeclarationContext ctx) {
        startMethod();
        super.enterMethodDeclaration(ctx)
    }

    @Override
    void exitMethodDeclaration(Java20Parser.MethodDeclarationContext ctx) {
        endMethod();
        super.exitMethodDeclaration(ctx)
    }

    @Override
    void enterConstructorDeclaration(Java20Parser.ConstructorDeclarationContext ctx) {
        startMethod();
        super.enterConstructorDeclaration(ctx)
    }

    @Override
    void exitConstructorDeclaration(Java20Parser.ConstructorDeclarationContext ctx) {
        endMethod();
        super.exitConstructorDeclaration(ctx)
    }

    @Override
    void enterInterfaceMethodDeclaration(Java20Parser.InterfaceMethodDeclarationContext ctx) {
        startMethod();
        super.enterInterfaceMethodDeclaration(ctx)
    }

    @Override
    void exitInterfaceMethodDeclaration(Java20Parser.InterfaceMethodDeclarationContext ctx) {
        endMethod();
        super.exitInterfaceMethodDeclaration(ctx)
    }

    @Override
    void enterLocalVariableDeclaration(Java20Parser.LocalVariableDeclarationContext ctx) {
        super.enterLocalVariableDeclaration(ctx)
    }

    @Override
    void exitBlockStatements(Java20Parser.BlockStatementsContext ctx) {
        super.exitBlockStatements(ctx)
    }

    @Override
    void enterBlockStatement(Java20Parser.BlockStatementContext ctx) {
        super.enterBlockStatement(ctx)
    }

    @Override
    void exitBlockStatement(Java20Parser.BlockStatementContext ctx) {
        super.exitBlockStatement(ctx)
    }

    @Override
    void enterLocalVariableDeclarationStatement(Java20Parser.LocalVariableDeclarationStatementContext ctx) {
        super.enterLocalVariableDeclarationStatement(ctx)
    }

    @Override
    void exitLocalVariableDeclarationStatement(Java20Parser.LocalVariableDeclarationStatementContext ctx) {
        super.exitLocalVariableDeclarationStatement(ctx)
    }

    @Override
    void enterEmptyStatement(Java20Parser.EmptyStatementContext ctx) {
        super.enterEmptyStatement(ctx)
    }

    @Override
    void exitEmptyStatement(Java20Parser.EmptyStatementContext ctx) {
        super.exitEmptyStatement(ctx)
    }

    @Override
    void enterLabeledStatement(Java20Parser.LabeledStatementContext ctx) {
        super.enterLabeledStatement(ctx)
    }

    @Override
    void exitLabeledStatement(Java20Parser.LabeledStatementContext ctx) {
        super.exitLabeledStatement(ctx)
    }

    @Override
    void enterLabeledStatementNoShortIf(Java20Parser.LabeledStatementNoShortIfContext ctx) {
        super.enterLabeledStatementNoShortIf(ctx)
    }

    @Override
    void exitLabeledStatementNoShortIf(Java20Parser.LabeledStatementNoShortIfContext ctx) {
        super.exitLabeledStatementNoShortIf(ctx)
    }

    @Override
    void enterExpressionStatement(Java20Parser.ExpressionStatementContext ctx) {
        super.enterExpressionStatement(ctx)
    }

    @Override
    void exitExpressionStatement(Java20Parser.ExpressionStatementContext ctx) {
        super.exitExpressionStatement(ctx)
    }

    @Override
    void enterIfThenStatement(Java20Parser.IfThenStatementContext ctx) {
        super.enterIfThenStatement(ctx)
    }

    @Override
    void exitIfThenStatement(Java20Parser.IfThenStatementContext ctx) {
        super.exitIfThenStatement(ctx)
    }

    @Override
    void enterIfThenElseStatement(Java20Parser.IfThenElseStatementContext ctx) {
        super.enterIfThenElseStatement(ctx)
    }

    @Override
    void exitIfThenElseStatement(Java20Parser.IfThenElseStatementContext ctx) {
        super.exitIfThenElseStatement(ctx)
    }

    @Override
    void enterIfThenElseStatementNoShortIf(Java20Parser.IfThenElseStatementNoShortIfContext ctx) {
        super.enterIfThenElseStatementNoShortIf(ctx)
    }

    @Override
    void exitIfThenElseStatementNoShortIf(Java20Parser.IfThenElseStatementNoShortIfContext ctx) {
        super.exitIfThenElseStatementNoShortIf(ctx)
    }

    @Override
    void enterAssertStatement(Java20Parser.AssertStatementContext ctx) {
        super.enterAssertStatement(ctx)
    }

    @Override
    void exitAssertStatement(Java20Parser.AssertStatementContext ctx) {
        super.exitAssertStatement(ctx)
    }

    @Override
    void exitSwitchStatement(Java20Parser.SwitchStatementContext ctx) {
        super.exitSwitchStatement(ctx)
    }

    @Override
    void exitSwitchBlockStatementGroup(Java20Parser.SwitchBlockStatementGroupContext ctx) {
        super.exitSwitchBlockStatementGroup(ctx)
    }

    @Override
    void enterWhileStatement(Java20Parser.WhileStatementContext ctx) {
        super.enterWhileStatement(ctx)
    }

    @Override
    void exitWhileStatement(Java20Parser.WhileStatementContext ctx) {
        super.exitWhileStatement(ctx)
    }

    @Override
    void enterWhileStatementNoShortIf(Java20Parser.WhileStatementNoShortIfContext ctx) {
        super.enterWhileStatementNoShortIf(ctx)
    }

    @Override
    void exitWhileStatementNoShortIf(Java20Parser.WhileStatementNoShortIfContext ctx) {
        super.exitWhileStatementNoShortIf(ctx)
    }

    @Override
    void enterDoStatement(Java20Parser.DoStatementContext ctx) {
        super.enterDoStatement(ctx)
    }

    @Override
    void exitDoStatement(Java20Parser.DoStatementContext ctx) {
        super.exitDoStatement(ctx)
    }

    @Override
    void enterForStatement(Java20Parser.ForStatementContext ctx) {
        super.enterForStatement(ctx)
    }

    @Override
    void exitForStatement(Java20Parser.ForStatementContext ctx) {
        super.exitForStatement(ctx)
    }

    @Override
    void enterForStatementNoShortIf(Java20Parser.ForStatementNoShortIfContext ctx) {
        super.enterForStatementNoShortIf(ctx)
    }

    @Override
    void exitForStatementNoShortIf(Java20Parser.ForStatementNoShortIfContext ctx) {
        super.exitForStatementNoShortIf(ctx)
    }

    @Override
    void enterBasicForStatement(Java20Parser.BasicForStatementContext ctx) {
        super.enterBasicForStatement(ctx)
    }

    @Override
    void exitBasicForStatement(Java20Parser.BasicForStatementContext ctx) {
        super.exitBasicForStatement(ctx)
    }

    @Override
    void enterBasicForStatementNoShortIf(Java20Parser.BasicForStatementNoShortIfContext ctx) {
        super.enterBasicForStatementNoShortIf(ctx)
    }

    @Override
    void exitBasicForStatementNoShortIf(Java20Parser.BasicForStatementNoShortIfContext ctx) {
        super.exitBasicForStatementNoShortIf(ctx)
    }

    @Override
    void enterEnhancedForStatement(Java20Parser.EnhancedForStatementContext ctx) {
        super.enterEnhancedForStatement(ctx)
    }

    @Override
    void exitEnhancedForStatement(Java20Parser.EnhancedForStatementContext ctx) {
        super.exitEnhancedForStatement(ctx)
    }

    @Override
    void enterEnhancedForStatementNoShortIf(Java20Parser.EnhancedForStatementNoShortIfContext ctx) {
        super.enterEnhancedForStatementNoShortIf(ctx)
    }

    @Override
    void exitEnhancedForStatementNoShortIf(Java20Parser.EnhancedForStatementNoShortIfContext ctx) {
        super.exitEnhancedForStatementNoShortIf(ctx)
    }

    @Override
    void enterBreakStatement(Java20Parser.BreakStatementContext ctx) {
        super.enterBreakStatement(ctx)
    }

    @Override
    void exitBreakStatement(Java20Parser.BreakStatementContext ctx) {
        super.exitBreakStatement(ctx)
    }

    @Override
    void enterContinueStatement(Java20Parser.ContinueStatementContext ctx) {
        super.enterContinueStatement(ctx)
    }

    @Override
    void exitContinueStatement(Java20Parser.ContinueStatementContext ctx) {
        super.exitContinueStatement(ctx)
    }

    @Override
    void enterReturnStatement(Java20Parser.ReturnStatementContext ctx) {
        super.enterReturnStatement(ctx)
    }

    @Override
    void exitReturnStatement(Java20Parser.ReturnStatementContext ctx) {
        super.exitReturnStatement(ctx)
    }

    @Override
    void enterThrowStatement(Java20Parser.ThrowStatementContext ctx) {
        super.enterThrowStatement(ctx)
    }

    @Override
    void exitThrowStatement(Java20Parser.ThrowStatementContext ctx) {
        super.exitThrowStatement(ctx)
    }

    @Override
    void enterSynchronizedStatement(Java20Parser.SynchronizedStatementContext ctx) {
        super.enterSynchronizedStatement(ctx)
    }

    @Override
    void exitSynchronizedStatement(Java20Parser.SynchronizedStatementContext ctx) {
        super.exitSynchronizedStatement(ctx)
    }

    @Override
    void enterTryStatement(Java20Parser.TryStatementContext ctx) {
        super.enterTryStatement(ctx)
    }

    @Override
    void exitTryStatement(Java20Parser.TryStatementContext ctx) {
        super.exitTryStatement(ctx)
    }

    @Override
    void enterTryWithResourcesStatement(Java20Parser.TryWithResourcesStatementContext ctx) {
        super.enterTryWithResourcesStatement(ctx)
    }

    @Override
    void exitTryWithResourcesStatement(Java20Parser.TryWithResourcesStatementContext ctx) {
        super.exitTryWithResourcesStatement(ctx)
    }

    @Override
    void enterYieldStatement(Java20Parser.YieldStatementContext ctx) {
        super.enterYieldStatement(ctx)
    }

    @Override
    void exitYieldStatement(Java20Parser.YieldStatementContext ctx) {
        super.exitYieldStatement(ctx)
    }

    @Override
    void enterSwitchBlockStatementGroup(Java20Parser.SwitchBlockStatementGroupContext ctx) {
        super.enterSwitchBlockStatementGroup(ctx)
    }

    @Override
    void enterCatchClause(Java20Parser.CatchClauseContext ctx) {
        super.enterCatchClause(ctx)
    }

    @Override
    void enterFinallyBlock(Java20Parser.FinallyBlockContext ctx) {
        super.enterFinallyBlock(ctx)
    }
}
