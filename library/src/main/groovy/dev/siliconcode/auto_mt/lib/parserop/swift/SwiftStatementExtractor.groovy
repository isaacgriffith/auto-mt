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
package dev.siliconcode.auto_mt.lib.parserop.swift

import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.swift.Swift5Parser

class SwiftStatementExtractor extends SwiftAbstractExtractor implements CFGStatementHandler {

    SwiftStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterFunction_declaration(Swift5Parser.Function_declarationContext ctx) {
        super.enterFunction_declaration(ctx)
    }

    @Override
    void exitFunction_declaration(Swift5Parser.Function_declarationContext ctx) {
        super.exitFunction_declaration(ctx)
    }

    @Override
    void enterProtocol_method_declaration(Swift5Parser.Protocol_method_declarationContext ctx) {
        super.enterProtocol_method_declaration(ctx)
    }

    @Override
    void exitProtocol_method_declaration(Swift5Parser.Protocol_method_declarationContext ctx) {
        super.exitProtocol_method_declaration(ctx)
    }

    @Override
    void enterProtocol_initializer_declaration(Swift5Parser.Protocol_initializer_declarationContext ctx) {
        super.enterProtocol_initializer_declaration(ctx)
    }

    @Override
    void exitProtocol_initializer_declaration(Swift5Parser.Protocol_initializer_declarationContext ctx) {
        super.exitProtocol_initializer_declaration(ctx)
    }

    @Override
    void enterInitializer_declaration(Swift5Parser.Initializer_declarationContext ctx) {
        super.enterInitializer_declaration(ctx)
    }

    @Override
    void exitInitializer_declaration(Swift5Parser.Initializer_declarationContext ctx) {
        super.exitInitializer_declaration(ctx)
    }

    @Override
    void enterDeinitializer_declaration(Swift5Parser.Deinitializer_declarationContext ctx) {
        super.enterDeinitializer_declaration(ctx)
    }

    @Override
    void exitDeinitializer_declaration(Swift5Parser.Deinitializer_declarationContext ctx) {
        super.exitDeinitializer_declaration(ctx)
    }

    @Override
    void enterOperator_declaration(Swift5Parser.Operator_declarationContext ctx) {
        super.enterOperator_declaration(ctx)
    }

    @Override
    void exitOperator_declaration(Swift5Parser.Operator_declarationContext ctx) {
        super.exitOperator_declaration(ctx)
    }

    @Override
    void enterPrefix_operator_declaration(Swift5Parser.Prefix_operator_declarationContext ctx) {
        super.enterPrefix_operator_declaration(ctx)
    }

    @Override
    void exitPrefix_operator_declaration(Swift5Parser.Prefix_operator_declarationContext ctx) {
        super.exitPrefix_operator_declaration(ctx)
    }

    @Override
    void enterPostfix_operator_declaration(Swift5Parser.Postfix_operator_declarationContext ctx) {
        super.enterPostfix_operator_declaration(ctx)
    }

    @Override
    void exitPostfix_operator_declaration(Swift5Parser.Postfix_operator_declarationContext ctx) {
        super.exitPostfix_operator_declaration(ctx)
    }

    @Override
    void enterInfix_operator_declaration(Swift5Parser.Infix_operator_declarationContext ctx) {
        super.enterInfix_operator_declaration(ctx)
    }

    @Override
    void exitInfix_operator_declaration(Swift5Parser.Infix_operator_declarationContext ctx) {
        super.exitInfix_operator_declaration(ctx)
    }

    @Override
    void enterStatement(Swift5Parser.StatementContext ctx) {
        super.enterStatement(ctx)
    }

    @Override
    void exitStatement(Swift5Parser.StatementContext ctx) {
        super.exitStatement(ctx)
    }

    @Override
    void enterLoop_statement(Swift5Parser.Loop_statementContext ctx) {
        super.enterLoop_statement(ctx)
    }

    @Override
    void exitLoop_statement(Swift5Parser.Loop_statementContext ctx) {
        super.exitLoop_statement(ctx)
    }

    @Override
    void enterFor_in_statement(Swift5Parser.For_in_statementContext ctx) {
        super.enterFor_in_statement(ctx)
    }

    @Override
    void exitFor_in_statement(Swift5Parser.For_in_statementContext ctx) {
        super.exitFor_in_statement(ctx)
    }

    @Override
    void enterWhile_statement(Swift5Parser.While_statementContext ctx) {
        super.enterWhile_statement(ctx)
    }

    @Override
    void exitWhile_statement(Swift5Parser.While_statementContext ctx) {
        super.exitWhile_statement(ctx)
    }

    @Override
    void enterRepeat_while_statement(Swift5Parser.Repeat_while_statementContext ctx) {
        super.enterRepeat_while_statement(ctx)
    }

    @Override
    void exitRepeat_while_statement(Swift5Parser.Repeat_while_statementContext ctx) {
        super.exitRepeat_while_statement(ctx)
    }

    @Override
    void enterBranch_statement(Swift5Parser.Branch_statementContext ctx) {
        super.enterBranch_statement(ctx)
    }

    @Override
    void exitBranch_statement(Swift5Parser.Branch_statementContext ctx) {
        super.exitBranch_statement(ctx)
    }

    @Override
    void enterIf_statement(Swift5Parser.If_statementContext ctx) {
        super.enterIf_statement(ctx)
    }

    @Override
    void exitIf_statement(Swift5Parser.If_statementContext ctx) {
        super.exitIf_statement(ctx)
    }

    @Override
    void enterGuard_statement(Swift5Parser.Guard_statementContext ctx) {
        super.enterGuard_statement(ctx)
    }

    @Override
    void exitGuard_statement(Swift5Parser.Guard_statementContext ctx) {
        super.exitGuard_statement(ctx)
    }

    @Override
    void enterSwitch_statement(Swift5Parser.Switch_statementContext ctx) {
        super.enterSwitch_statement(ctx)
    }

    @Override
    void exitSwitch_statement(Swift5Parser.Switch_statementContext ctx) {
        super.exitSwitch_statement(ctx)
    }

    @Override
    void enterLabeled_statement(Swift5Parser.Labeled_statementContext ctx) {
        super.enterLabeled_statement(ctx)
    }

    @Override
    void exitLabeled_statement(Swift5Parser.Labeled_statementContext ctx) {
        super.exitLabeled_statement(ctx)
    }

    @Override
    void enterControl_transfer_statement(Swift5Parser.Control_transfer_statementContext ctx) {
        super.enterControl_transfer_statement(ctx)
    }

    @Override
    void exitControl_transfer_statement(Swift5Parser.Control_transfer_statementContext ctx) {
        super.exitControl_transfer_statement(ctx)
    }

    @Override
    void enterBreak_statement(Swift5Parser.Break_statementContext ctx) {
        super.enterBreak_statement(ctx)
    }

    @Override
    void exitBreak_statement(Swift5Parser.Break_statementContext ctx) {
        super.exitBreak_statement(ctx)
    }

    @Override
    void enterContinue_statement(Swift5Parser.Continue_statementContext ctx) {
        super.enterContinue_statement(ctx)
    }

    @Override
    void exitContinue_statement(Swift5Parser.Continue_statementContext ctx) {
        super.exitContinue_statement(ctx)
    }

    @Override
    void enterFallthrough_statement(Swift5Parser.Fallthrough_statementContext ctx) {
        super.enterFallthrough_statement(ctx)
    }

    @Override
    void exitFallthrough_statement(Swift5Parser.Fallthrough_statementContext ctx) {
        super.exitFallthrough_statement(ctx)
    }

    @Override
    void enterReturn_statement(Swift5Parser.Return_statementContext ctx) {
        super.enterReturn_statement(ctx)
    }

    @Override
    void exitReturn_statement(Swift5Parser.Return_statementContext ctx) {
        super.exitReturn_statement(ctx)
    }

    @Override
    void enterThrow_statement(Swift5Parser.Throw_statementContext ctx) {
        super.enterThrow_statement(ctx)
    }

    @Override
    void exitThrow_statement(Swift5Parser.Throw_statementContext ctx) {
        super.exitThrow_statement(ctx)
    }

    @Override
    void enterDefer_statement(Swift5Parser.Defer_statementContext ctx) {
        super.enterDefer_statement(ctx)
    }

    @Override
    void exitDefer_statement(Swift5Parser.Defer_statementContext ctx) {
        super.exitDefer_statement(ctx)
    }

    @Override
    void enterDo_statement(Swift5Parser.Do_statementContext ctx) {
        super.enterDo_statement(ctx)
    }

    @Override
    void exitDo_statement(Swift5Parser.Do_statementContext ctx) {
        super.exitDo_statement(ctx)
    }

    @Override
    void exitCompiler_control_statement(Swift5Parser.Compiler_control_statementContext ctx) {
        super.exitCompiler_control_statement(ctx)
    }

    @Override
    void enterLine_control_statement(Swift5Parser.Line_control_statementContext ctx) {
        super.enterLine_control_statement(ctx)
    }

    @Override
    void exitLine_control_statement(Swift5Parser.Line_control_statementContext ctx) {
        super.exitLine_control_statement(ctx)
    }

    @Override
    void enterDiagnostic_statement(Swift5Parser.Diagnostic_statementContext ctx) {
        super.enterDiagnostic_statement(ctx)
    }

    @Override
    void exitDiagnostic_statement(Swift5Parser.Diagnostic_statementContext ctx) {
        super.exitDiagnostic_statement(ctx)
    }

    @Override
    void enterSwitch_case(Swift5Parser.Switch_caseContext ctx) {
        super.enterSwitch_case(ctx)
    }

    @Override
    void exitSwitch_case(Swift5Parser.Switch_caseContext ctx) {
        super.exitSwitch_case(ctx)
    }
}
