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
package dev.siliconcode.auto_mt.lib.parserop.objc

import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.parsers.objc.ObjectiveCParser

class ObjCStatementExtractor extends ObjCAbstractExtractor implements CFGStatementHandler {

    ObjCStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterProtocolDeclaration(ObjectiveCParser.ProtocolDeclarationContext ctx) {
        super.enterProtocolDeclaration(ctx)
    }

    @Override
    void exitProtocolDeclaration(ObjectiveCParser.ProtocolDeclarationContext ctx) {
        super.exitProtocolDeclaration(ctx)
    }

    @Override
    void enterPropertyDeclaration(ObjectiveCParser.PropertyDeclarationContext ctx) {
        super.enterPropertyDeclaration(ctx)
    }

    @Override
    void exitPropertyDeclaration(ObjectiveCParser.PropertyDeclarationContext ctx) {
        super.exitPropertyDeclaration(ctx)
    }

    @Override
    void enterClassMethodDeclaration(ObjectiveCParser.ClassMethodDeclarationContext ctx) {
        super.enterClassMethodDeclaration(ctx)
    }

    @Override
    void exitClassMethodDeclaration(ObjectiveCParser.ClassMethodDeclarationContext ctx) {
        super.exitClassMethodDeclaration(ctx)
    }

    @Override
    void enterInstanceMethodDeclaration(ObjectiveCParser.InstanceMethodDeclarationContext ctx) {
        super.enterInstanceMethodDeclaration(ctx)
    }

    @Override
    void exitInstanceMethodDeclaration(ObjectiveCParser.InstanceMethodDeclarationContext ctx) {
        super.exitInstanceMethodDeclaration(ctx)
    }

    @Override
    void enterMethodDeclaration(ObjectiveCParser.MethodDeclarationContext ctx) {
        super.enterMethodDeclaration(ctx)
    }

    @Override
    void exitMethodDeclaration(ObjectiveCParser.MethodDeclarationContext ctx) {
        super.exitMethodDeclaration(ctx)
    }

    @Override
    void enterFunctionDeclaration(ObjectiveCParser.FunctionDeclarationContext ctx) {
        super.enterFunctionDeclaration(ctx)
    }

    @Override
    void exitFunctionDeclaration(ObjectiveCParser.FunctionDeclarationContext ctx) {
        super.exitFunctionDeclaration(ctx)
    }

    @Override
    void enterVarDeclaration(ObjectiveCParser.VarDeclarationContext ctx) {
        super.enterVarDeclaration(ctx)
    }

    @Override
    void exitVarDeclaration(ObjectiveCParser.VarDeclarationContext ctx) {
        super.exitVarDeclaration(ctx)
    }

    @Override
    void enterThrowStatement(ObjectiveCParser.ThrowStatementContext ctx) {
        super.enterThrowStatement(ctx)
    }

    @Override
    void exitThrowStatement(ObjectiveCParser.ThrowStatementContext ctx) {
        super.exitThrowStatement(ctx)
    }

    @Override
    void enterCatchStatement(ObjectiveCParser.CatchStatementContext ctx) {
        super.enterCatchStatement(ctx)
    }

    @Override
    void exitCatchStatement(ObjectiveCParser.CatchStatementContext ctx) {
        super.exitCatchStatement(ctx)
    }

    @Override
    void enterSynchronizedStatement(ObjectiveCParser.SynchronizedStatementContext ctx) {
        super.enterSynchronizedStatement(ctx)
    }

    @Override
    void exitSynchronizedStatement(ObjectiveCParser.SynchronizedStatementContext ctx) {
        super.exitSynchronizedStatement(ctx)
    }

    @Override
    void enterAutoreleaseStatement(ObjectiveCParser.AutoreleaseStatementContext ctx) {
        super.enterAutoreleaseStatement(ctx)
    }

    @Override
    void exitAutoreleaseStatement(ObjectiveCParser.AutoreleaseStatementContext ctx) {
        super.exitAutoreleaseStatement(ctx)
    }

    @Override
    void enterStatement(ObjectiveCParser.StatementContext ctx) {
        super.enterStatement(ctx)
    }

    @Override
    void exitStatement(ObjectiveCParser.StatementContext ctx) {
        super.exitStatement(ctx)
    }

    @Override
    void enterLabeledStatement(ObjectiveCParser.LabeledStatementContext ctx) {
        super.enterLabeledStatement(ctx)
    }

    @Override
    void exitLabeledStatement(ObjectiveCParser.LabeledStatementContext ctx) {
        super.exitLabeledStatement(ctx)
    }

    @Override
    void enterCompoundStatement(ObjectiveCParser.CompoundStatementContext ctx) {
        super.enterCompoundStatement(ctx)
    }

    @Override
    void exitCompoundStatement(ObjectiveCParser.CompoundStatementContext ctx) {
        super.exitCompoundStatement(ctx)
    }

    @Override
    void enterSelectionStatement(ObjectiveCParser.SelectionStatementContext ctx) {
        super.enterSelectionStatement(ctx)
    }

    @Override
    void exitSelectionStatement(ObjectiveCParser.SelectionStatementContext ctx) {
        super.exitSelectionStatement(ctx)
    }

    @Override
    void enterSwitchStatement(ObjectiveCParser.SwitchStatementContext ctx) {
        super.enterSwitchStatement(ctx)
    }

    @Override
    void exitSwitchStatement(ObjectiveCParser.SwitchStatementContext ctx) {
        super.exitSwitchStatement(ctx)
    }

    @Override
    void enterIterationStatement(ObjectiveCParser.IterationStatementContext ctx) {
        super.enterIterationStatement(ctx)
    }

    @Override
    void exitIterationStatement(ObjectiveCParser.IterationStatementContext ctx) {
        super.exitIterationStatement(ctx)
    }

    @Override
    void enterWhileStatement(ObjectiveCParser.WhileStatementContext ctx) {
        super.enterWhileStatement(ctx)
    }

    @Override
    void exitWhileStatement(ObjectiveCParser.WhileStatementContext ctx) {
        super.exitWhileStatement(ctx)
    }

    @Override
    void enterDoStatement(ObjectiveCParser.DoStatementContext ctx) {
        super.enterDoStatement(ctx)
    }

    @Override
    void exitDoStatement(ObjectiveCParser.DoStatementContext ctx) {
        super.exitDoStatement(ctx)
    }

    @Override
    void enterForStatement(ObjectiveCParser.ForStatementContext ctx) {
        super.enterForStatement(ctx)
    }

    @Override
    void exitForStatement(ObjectiveCParser.ForStatementContext ctx) {
        super.exitForStatement(ctx)
    }

    @Override
    void enterForInStatement(ObjectiveCParser.ForInStatementContext ctx) {
        super.enterForInStatement(ctx)
    }

    @Override
    void exitForInStatement(ObjectiveCParser.ForInStatementContext ctx) {
        super.exitForInStatement(ctx)
    }

    @Override
    void enterJumpStatement(ObjectiveCParser.JumpStatementContext ctx) {
        super.enterJumpStatement(ctx)
    }

    @Override
    void exitJumpStatement(ObjectiveCParser.JumpStatementContext ctx) {
        super.exitJumpStatement(ctx)
    }
}
