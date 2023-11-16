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
package dev.siliconcode.auto_mt.lib.parserop.ts

import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.ts.TypeScriptParser

class TypeScriptStatementExtractor extends TypeScriptAbstractExtractor implements CFGStatementHandler {

    TypeScriptStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterConstructorDeclaration(TypeScriptParser.ConstructorDeclarationContext ctx) {
        super.enterConstructorDeclaration(ctx)
    }

    @Override
    void exitConstructorDeclaration(TypeScriptParser.ConstructorDeclarationContext ctx) {
        super.exitConstructorDeclaration(ctx)
    }

    @Override
    void enterFunctionDeclaration(TypeScriptParser.FunctionDeclarationContext ctx) {
        super.enterFunctionDeclaration(ctx)
    }

    @Override
    void exitFunctionDeclaration(TypeScriptParser.FunctionDeclarationContext ctx) {
        super.exitFunctionDeclaration(ctx)
    }

    @Override
    void enterPropertyDeclarationExpression(TypeScriptParser.PropertyDeclarationExpressionContext ctx) {
        super.enterPropertyDeclarationExpression(ctx)
    }

    @Override
    void exitPropertyDeclarationExpression(TypeScriptParser.PropertyDeclarationExpressionContext ctx) {
        super.exitPropertyDeclarationExpression(ctx)
    }

    @Override
    void enterMethodDeclarationExpression(TypeScriptParser.MethodDeclarationExpressionContext ctx) {
        super.enterMethodDeclarationExpression(ctx)
    }

    @Override
    void exitMethodDeclarationExpression(TypeScriptParser.MethodDeclarationExpressionContext ctx) {
        super.exitMethodDeclarationExpression(ctx)
    }

    @Override
    void enterGetterSetterDeclarationExpression(TypeScriptParser.GetterSetterDeclarationExpressionContext ctx) {
        super.enterGetterSetterDeclarationExpression(ctx)
    }

    @Override
    void exitGetterSetterDeclarationExpression(TypeScriptParser.GetterSetterDeclarationExpressionContext ctx) {
        super.exitGetterSetterDeclarationExpression(ctx)
    }

    @Override
    void enterGeneratorFunctionDeclaration(TypeScriptParser.GeneratorFunctionDeclarationContext ctx) {
        super.enterGeneratorFunctionDeclaration(ctx)
    }

    @Override
    void exitGeneratorFunctionDeclaration(TypeScriptParser.GeneratorFunctionDeclarationContext ctx) {
        super.exitGeneratorFunctionDeclaration(ctx)
    }

    @Override
    void enterFunctionExpressionDeclaration(TypeScriptParser.FunctionExpressionDeclarationContext ctx) {
        super.enterFunctionExpressionDeclaration(ctx)
    }

    @Override
    void exitFunctionExpressionDeclaration(TypeScriptParser.FunctionExpressionDeclarationContext ctx) {
        super.exitFunctionExpressionDeclaration(ctx)
    }

    @Override
    void enterArrowFunctionDeclaration(TypeScriptParser.ArrowFunctionDeclarationContext ctx) {
        super.enterArrowFunctionDeclaration(ctx)
    }

    @Override
    void exitArrowFunctionDeclaration(TypeScriptParser.ArrowFunctionDeclarationContext ctx) {
        super.exitArrowFunctionDeclaration(ctx)
    }

    @Override
    void enterStatement(TypeScriptParser.StatementContext ctx) {
        super.enterStatement(ctx)
    }

    @Override
    void exitStatement(TypeScriptParser.StatementContext ctx) {
        super.exitStatement(ctx)
    }

    @Override
    void enterExportStatement(TypeScriptParser.ExportStatementContext ctx) {
        super.enterExportStatement(ctx)
    }

    @Override
    void enterVariableStatement(TypeScriptParser.VariableStatementContext ctx) {
        super.enterVariableStatement(ctx)
    }

    @Override
    void exitVariableStatement(TypeScriptParser.VariableStatementContext ctx) {
        super.exitVariableStatement(ctx)
    }

    @Override
    void enterEmptyStatement_(TypeScriptParser.EmptyStatement_Context ctx) {
        super.enterEmptyStatement_(ctx)
    }

    @Override
    void exitEmptyStatement_(TypeScriptParser.EmptyStatement_Context ctx) {
        super.exitEmptyStatement_(ctx)
    }

    @Override
    void enterExpressionStatement(TypeScriptParser.ExpressionStatementContext ctx) {
        super.enterExpressionStatement(ctx)
    }

    @Override
    void exitExpressionStatement(TypeScriptParser.ExpressionStatementContext ctx) {
        super.exitExpressionStatement(ctx)
    }

    @Override
    void enterIfStatement(TypeScriptParser.IfStatementContext ctx) {
        super.enterIfStatement(ctx)
    }

    @Override
    void exitIfStatement(TypeScriptParser.IfStatementContext ctx) {
        super.exitIfStatement(ctx)
    }

    @Override
    void enterDoStatement(TypeScriptParser.DoStatementContext ctx) {
        super.enterDoStatement(ctx)
    }

    @Override
    void exitDoStatement(TypeScriptParser.DoStatementContext ctx) {
        super.exitDoStatement(ctx)
    }

    @Override
    void enterWhileStatement(TypeScriptParser.WhileStatementContext ctx) {
        super.enterWhileStatement(ctx)
    }

    @Override
    void exitWhileStatement(TypeScriptParser.WhileStatementContext ctx) {
        super.exitWhileStatement(ctx)
    }

    @Override
    void enterForStatement(TypeScriptParser.ForStatementContext ctx) {
        super.enterForStatement(ctx)
    }

    @Override
    void exitForStatement(TypeScriptParser.ForStatementContext ctx) {
        super.exitForStatement(ctx)
    }

    @Override
    void enterForVarStatement(TypeScriptParser.ForVarStatementContext ctx) {
        super.enterForVarStatement(ctx)
    }

    @Override
    void exitForVarStatement(TypeScriptParser.ForVarStatementContext ctx) {
        super.exitForVarStatement(ctx)
    }

    @Override
    void enterForInStatement(TypeScriptParser.ForInStatementContext ctx) {
        super.enterForInStatement(ctx)
    }

    @Override
    void exitForInStatement(TypeScriptParser.ForInStatementContext ctx) {
        super.exitForInStatement(ctx)
    }

    @Override
    void enterForVarInStatement(TypeScriptParser.ForVarInStatementContext ctx) {
        super.enterForVarInStatement(ctx)
    }

    @Override
    void exitForVarInStatement(TypeScriptParser.ForVarInStatementContext ctx) {
        super.exitForVarInStatement(ctx)
    }

    @Override
    void enterContinueStatement(TypeScriptParser.ContinueStatementContext ctx) {
        super.enterContinueStatement(ctx)
    }

    @Override
    void exitContinueStatement(TypeScriptParser.ContinueStatementContext ctx) {
        super.exitContinueStatement(ctx)
    }

    @Override
    void enterBreakStatement(TypeScriptParser.BreakStatementContext ctx) {
        super.enterBreakStatement(ctx)
    }

    @Override
    void exitBreakStatement(TypeScriptParser.BreakStatementContext ctx) {
        super.exitBreakStatement(ctx)
    }

    @Override
    void enterReturnStatement(TypeScriptParser.ReturnStatementContext ctx) {
        super.enterReturnStatement(ctx)
    }

    @Override
    void exitReturnStatement(TypeScriptParser.ReturnStatementContext ctx) {
        super.exitReturnStatement(ctx)
    }

    @Override
    void enterYieldStatement(TypeScriptParser.YieldStatementContext ctx) {
        super.enterYieldStatement(ctx)
    }

    @Override
    void exitYieldStatement(TypeScriptParser.YieldStatementContext ctx) {
        super.exitYieldStatement(ctx)
    }

    @Override
    void enterWithStatement(TypeScriptParser.WithStatementContext ctx) {
        super.enterWithStatement(ctx)
    }

    @Override
    void exitWithStatement(TypeScriptParser.WithStatementContext ctx) {
        super.exitWithStatement(ctx)
    }

    @Override
    void enterSwitchStatement(TypeScriptParser.SwitchStatementContext ctx) {
        super.enterSwitchStatement(ctx)
    }

    @Override
    void exitSwitchStatement(TypeScriptParser.SwitchStatementContext ctx) {
        super.exitSwitchStatement(ctx)
    }

    @Override
    void enterLabelledStatement(TypeScriptParser.LabelledStatementContext ctx) {
        super.enterLabelledStatement(ctx)
    }

    @Override
    void exitLabelledStatement(TypeScriptParser.LabelledStatementContext ctx) {
        super.exitLabelledStatement(ctx)
    }

    @Override
    void enterThrowStatement(TypeScriptParser.ThrowStatementContext ctx) {
        super.enterThrowStatement(ctx)
    }

    @Override
    void exitThrowStatement(TypeScriptParser.ThrowStatementContext ctx) {
        super.exitThrowStatement(ctx)
    }

    @Override
    void enterTryStatement(TypeScriptParser.TryStatementContext ctx) {
        super.enterTryStatement(ctx)
    }

    @Override
    void exitTryStatement(TypeScriptParser.TryStatementContext ctx) {
        super.exitTryStatement(ctx)
    }

    @Override
    void enterDebuggerStatement(TypeScriptParser.DebuggerStatementContext ctx) {
        super.enterDebuggerStatement(ctx)
    }

    @Override
    void exitDebuggerStatement(TypeScriptParser.DebuggerStatementContext ctx) {
        super.exitDebuggerStatement(ctx)
    }
}
