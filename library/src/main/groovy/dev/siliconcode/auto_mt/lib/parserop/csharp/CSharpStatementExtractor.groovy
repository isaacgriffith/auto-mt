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
package dev.siliconcode.auto_mt.lib.parserop.csharp

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.parsers.csharp.CSharpParser

class CSharpStatementExtractor extends CSharpAbstractExtractor implements CFGStatementHandler {

    CSharpStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterAccessor_declarations(CSharpParser.Accessor_declarationsContext ctx) {
        super.enterAccessor_declarations(ctx)
    }

    @Override
    void exitAccessor_declarations(CSharpParser.Accessor_declarationsContext ctx) {
        super.exitAccessor_declarations(ctx)
    }

    @Override
    void enterGet_accessor_declaration(CSharpParser.Get_accessor_declarationContext ctx) {
        super.enterGet_accessor_declaration(ctx)
    }

    @Override
    void exitGet_accessor_declaration(CSharpParser.Get_accessor_declarationContext ctx) {
        super.exitGet_accessor_declaration(ctx)
    }

    @Override
    void enterSet_accessor_declaration(CSharpParser.Set_accessor_declarationContext ctx) {
        super.enterSet_accessor_declaration(ctx)
    }

    @Override
    void exitSet_accessor_declaration(CSharpParser.Set_accessor_declarationContext ctx) {
        super.exitSet_accessor_declaration(ctx)
    }

    @Override
    void enterEvent_accessor_declarations(CSharpParser.Event_accessor_declarationsContext ctx) {
        super.enterEvent_accessor_declarations(ctx)
    }

    @Override
    void exitEvent_accessor_declarations(CSharpParser.Event_accessor_declarationsContext ctx) {
        super.exitEvent_accessor_declarations(ctx)
    }

    @Override
    void enterAdd_accessor_declaration(CSharpParser.Add_accessor_declarationContext ctx) {
        super.enterAdd_accessor_declaration(ctx)
    }

    @Override
    void exitAdd_accessor_declaration(CSharpParser.Add_accessor_declarationContext ctx) {
        super.exitAdd_accessor_declaration(ctx)
    }

    @Override
    void enterRemove_accessor_declaration(CSharpParser.Remove_accessor_declarationContext ctx) {
        super.enterRemove_accessor_declaration(ctx)
    }

    @Override
    void exitRemove_accessor_declaration(CSharpParser.Remove_accessor_declarationContext ctx) {
        super.exitRemove_accessor_declaration(ctx)
    }

    @Override
    void enterEvent_declaration(CSharpParser.Event_declarationContext ctx) {
        super.enterEvent_declaration(ctx)
    }

    @Override
    void exitEvent_declaration(CSharpParser.Event_declarationContext ctx) {
        super.exitEvent_declaration(ctx)
    }

    @Override
    void enterProperty_declaration(CSharpParser.Property_declarationContext ctx) {
        super.enterProperty_declaration(ctx)
    }

    @Override
    void enterIndexer_declaration(CSharpParser.Indexer_declarationContext ctx) {
        super.enterIndexer_declaration(ctx)
    }

    @Override
    void exitIndexer_declaration(CSharpParser.Indexer_declarationContext ctx) {
        super.exitIndexer_declaration(ctx)
    }

    @Override
    void enterConstructor_declaration(CSharpParser.Constructor_declarationContext ctx) {
        super.enterConstructor_declaration(ctx)
    }

    @Override
    void exitConstructor_declaration(CSharpParser.Constructor_declarationContext ctx) {
        super.exitConstructor_declaration(ctx)
    }

    @Override
    void enterMethod_declaration(CSharpParser.Method_declarationContext ctx) {
        super.enterMethod_declaration(ctx)
    }

    @Override
    void exitMethod_declaration(CSharpParser.Method_declarationContext ctx) {
        super.exitMethod_declaration(ctx)
    }

    @Override
    void enterOperator_declaration(CSharpParser.Operator_declarationContext ctx) {
        super.enterOperator_declaration(ctx)
    }

    @Override
    void exitOperator_declaration(CSharpParser.Operator_declarationContext ctx) {
        super.exitOperator_declaration(ctx)
    }

    @Override
    void enterDeclarationStatement(CSharpParser.DeclarationStatementContext ctx) {
        super.enterDeclarationStatement(ctx)
    }

    @Override
    void exitDeclarationStatement(CSharpParser.DeclarationStatementContext ctx) {
        super.exitDeclarationStatement(ctx)
    }

    @Override
    void enterLabeled_Statement(CSharpParser.Labeled_StatementContext ctx) {
        super.enterLabeled_Statement(ctx)
    }

    @Override
    void exitLabeled_Statement(CSharpParser.Labeled_StatementContext ctx) {
        super.exitLabeled_Statement(ctx)
    }

    @Override
    void enterEmbedded_statement(CSharpParser.Embedded_statementContext ctx) {
        super.enterEmbedded_statement(ctx)
    }

    @Override
    void exitEmbedded_statement(CSharpParser.Embedded_statementContext ctx) {
        super.exitEmbedded_statement(ctx)
    }

    @Override
    void enterTheEmptyStatement(CSharpParser.TheEmptyStatementContext ctx) {
        super.enterTheEmptyStatement(ctx)
    }

    @Override
    void exitTheEmptyStatement(CSharpParser.TheEmptyStatementContext ctx) {
        super.exitTheEmptyStatement(ctx)
    }

    @Override
    void enterExpressionStatement(CSharpParser.ExpressionStatementContext ctx) {
        super.enterExpressionStatement(ctx)
    }

    @Override
    void exitExpressionStatement(CSharpParser.ExpressionStatementContext ctx) {
        super.exitExpressionStatement(ctx)
    }

    @Override
    void enterIfStatement(CSharpParser.IfStatementContext ctx) {
        super.enterIfStatement(ctx)
    }

    @Override
    void exitIfStatement(CSharpParser.IfStatementContext ctx) {
        super.exitIfStatement(ctx)
    }

    @Override
    void enterSwitchStatement(CSharpParser.SwitchStatementContext ctx) {
        super.enterSwitchStatement(ctx)
    }

    @Override
    void exitSwitchStatement(CSharpParser.SwitchStatementContext ctx) {
        super.exitSwitchStatement(ctx)
    }

    @Override
    void enterWhileStatement(CSharpParser.WhileStatementContext ctx) {
        super.enterWhileStatement(ctx)
    }

    @Override
    void exitWhileStatement(CSharpParser.WhileStatementContext ctx) {
        super.exitWhileStatement(ctx)
    }

    @Override
    void enterDoStatement(CSharpParser.DoStatementContext ctx) {
        super.enterDoStatement(ctx)
    }

    @Override
    void exitDoStatement(CSharpParser.DoStatementContext ctx) {
        super.exitDoStatement(ctx)
    }

    @Override
    void enterForStatement(CSharpParser.ForStatementContext ctx) {
        super.enterForStatement(ctx)
    }

    @Override
    void exitForStatement(CSharpParser.ForStatementContext ctx) {
        super.exitForStatement(ctx)
    }

    @Override
    void enterForeachStatement(CSharpParser.ForeachStatementContext ctx) {
        super.enterForeachStatement(ctx)
    }

    @Override
    void exitForeachStatement(CSharpParser.ForeachStatementContext ctx) {
        super.exitForeachStatement(ctx)
    }

    @Override
    void enterBreakStatement(CSharpParser.BreakStatementContext ctx) {
        super.enterBreakStatement(ctx)
    }

    @Override
    void exitBreakStatement(CSharpParser.BreakStatementContext ctx) {
        super.exitBreakStatement(ctx)
    }

    @Override
    void enterContinueStatement(CSharpParser.ContinueStatementContext ctx) {
        super.enterContinueStatement(ctx)
    }

    @Override
    void exitContinueStatement(CSharpParser.ContinueStatementContext ctx) {
        super.exitContinueStatement(ctx)
    }

    @Override
    void enterGotoStatement(CSharpParser.GotoStatementContext ctx) {
        super.enterGotoStatement(ctx)
    }

    @Override
    void exitGotoStatement(CSharpParser.GotoStatementContext ctx) {
        super.exitGotoStatement(ctx)
    }

    @Override
    void enterReturnStatement(CSharpParser.ReturnStatementContext ctx) {
        super.enterReturnStatement(ctx)
    }

    @Override
    void exitReturnStatement(CSharpParser.ReturnStatementContext ctx) {
        super.exitReturnStatement(ctx)
    }

    @Override
    void enterThrowStatement(CSharpParser.ThrowStatementContext ctx) {
        super.enterThrowStatement(ctx)
    }

    @Override
    void exitThrowStatement(CSharpParser.ThrowStatementContext ctx) {
        super.exitThrowStatement(ctx)
    }

    @Override
    void enterTryStatement(CSharpParser.TryStatementContext ctx) {
        super.enterTryStatement(ctx)
    }

    @Override
    void exitTryStatement(CSharpParser.TryStatementContext ctx) {
        super.exitTryStatement(ctx)
    }

    @Override
    void enterCheckedStatement(CSharpParser.CheckedStatementContext ctx) {
        super.enterCheckedStatement(ctx)
    }

    @Override
    void exitCheckedStatement(CSharpParser.CheckedStatementContext ctx) {
        super.exitCheckedStatement(ctx)
    }

    @Override
    void enterUncheckedStatement(CSharpParser.UncheckedStatementContext ctx) {
        super.enterUncheckedStatement(ctx)
    }

    @Override
    void exitUncheckedStatement(CSharpParser.UncheckedStatementContext ctx) {
        super.exitUncheckedStatement(ctx)
    }

    @Override
    void enterLockStatement(CSharpParser.LockStatementContext ctx) {
        super.enterLockStatement(ctx)
    }

    @Override
    void exitLockStatement(CSharpParser.LockStatementContext ctx) {
        super.exitLockStatement(ctx)
    }

    @Override
    void enterUsingStatement(CSharpParser.UsingStatementContext ctx) {
        super.enterUsingStatement(ctx)
    }

    @Override
    void exitUsingStatement(CSharpParser.UsingStatementContext ctx) {
        super.exitUsingStatement(ctx)
    }

    @Override
    void enterYieldStatement(CSharpParser.YieldStatementContext ctx) {
        super.enterYieldStatement(ctx)
    }

    @Override
    void exitYieldStatement(CSharpParser.YieldStatementContext ctx) {
        super.exitYieldStatement(ctx)
    }

    @Override
    void enterUnsafeStatement(CSharpParser.UnsafeStatementContext ctx) {
        super.enterUnsafeStatement(ctx)
    }

    @Override
    void exitUnsafeStatement(CSharpParser.UnsafeStatementContext ctx) {
        super.exitUnsafeStatement(ctx)
    }

    @Override
    void enterFixedStatement(CSharpParser.FixedStatementContext ctx) {
        super.enterFixedStatement(ctx)
    }

    @Override
    void exitFixedStatement(CSharpParser.FixedStatementContext ctx) {
        super.exitFixedStatement(ctx)
    }
}
