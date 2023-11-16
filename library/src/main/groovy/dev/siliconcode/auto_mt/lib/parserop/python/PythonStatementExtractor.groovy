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
package dev.siliconcode.auto_mt.lib.parserop.python


import dev.siliconcode.auto_mt.lib.cfg.JumpTo
import dev.siliconcode.auto_mt.lib.cfg.StatementType
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.parsers.univ_python.PythonParser
import groovy.util.logging.Slf4j
/**
 * Extracts statements from a Python AST
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class PythonStatementExtractor extends PythonAbstractExtractor implements CFGStatementHandler {

    PythonStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    void enterRoot(PythonParser.RootContext ctx) {
        super.enterRoot(ctx)
        startScript()
    }

    void exitRoot(PythonParser.RootContext ctx) {
        super.exitRoot(ctx)
        endScript()
    }

    @Override
    void enterFuncdef(PythonParser.FuncdefContext ctx) {
        super.enterFuncdef(ctx)
        startMethod()
    }

    @Override
    void exitFuncdef(PythonParser.FuncdefContext ctx) {
        endMethod()
        super.exitFuncdef(ctx)
    }

    /////////////////
    // Statements
    /////////////////
    @Override
    void enterIf_stmt(PythonParser.If_stmtContext ctx) {
        super.enterIf_stmt(ctx)
        cfgBuilder.startDecision(StatementType.IF)
    }

    @Override
    void exitIf_stmt(PythonParser.If_stmtContext ctx) {
        super.exitIf_stmt(ctx)
        cfgBuilder.endDecision()
    }

    @Override
    void enterWhile_stmt(PythonParser.While_stmtContext ctx) {
        super.enterWhile_stmt(ctx)
        cfgBuilder.startLoop(StatementType.WHILE)
    }

    @Override
    void exitWhile_stmt(PythonParser.While_stmtContext ctx) {
        super.exitWhile_stmt(ctx)
        cfgBuilder.endLoop()
    }

    @Override
    void enterFor_stmt(PythonParser.For_stmtContext ctx) {
        super.enterFor_stmt(ctx)
        cfgBuilder.startLoop(StatementType.FOR)
    }

    @Override
    void exitFor_stmt(PythonParser.For_stmtContext ctx) {
        super.exitFor_stmt(ctx)
        cfgBuilder.endLoop()
    }

    @Override
    void enterTry_stmt(PythonParser.Try_stmtContext ctx) {
        super.enterTry_stmt(ctx)
        cfgBuilder.startBlock(StatementType.TRY)
    }

    @Override
    void exitTry_stmt(PythonParser.Try_stmtContext ctx) {
        super.exitTry_stmt(ctx)
        cfgBuilder.endBlock()
    }

    @Override
    void enterWith_stmt(PythonParser.With_stmtContext ctx) {
        super.enterWith_stmt(ctx)
        cfgBuilder.startBlock(StatementType.WITH)
    }

    @Override
    void exitWith_stmt(PythonParser.With_stmtContext ctx) {
        super.exitWith_stmt(ctx)
        cfgBuilder.endBlock()
    }

    @Override
    void enterExpr_stmt(PythonParser.Expr_stmtContext ctx) {
        super.enterExpr_stmt(ctx)
        cfgBuilder.createStatement(StatementType.EXPRESSION)
    }

    @Override
    void enterPrint_stmt(PythonParser.Print_stmtContext ctx) {
        super.enterPrint_stmt(ctx)
        cfgBuilder.createStatement(StatementType.PRINT)
    }

    @Override
    void enterDel_stmt(PythonParser.Del_stmtContext ctx) {
        super.enterDel_stmt(ctx)
    }

    @Override
    void exitDel_stmt(PythonParser.Del_stmtContext ctx) {
        super.exitDel_stmt(ctx)
    }

    @Override
    void enterPass_stmt(PythonParser.Pass_stmtContext ctx) {
        super.enterPass_stmt(ctx)
        cfgBuilder.createStatement(StatementType.PASS)
    }

    @Override
    void exitPass_stmt(PythonParser.Pass_stmtContext ctx) {
        super.exitPass_stmt(ctx)
    }

    @Override
    void enterBreak_stmt(PythonParser.Break_stmtContext ctx) {
        super.enterBreak_stmt(ctx)
        cfgBuilder.createStatement(StatementType.BREAK, null, true, JumpTo.LOOP_END)
    }

    @Override
    void enterContinue_stmt(PythonParser.Continue_stmtContext ctx) {
        super.enterContinue_stmt(ctx)
        cfgBuilder.createStatement(StatementType.CONTINUE, null, true, JumpTo.LOOP_START)
    }

    @Override
    void enterReturn_stmt(PythonParser.Return_stmtContext ctx) {
        super.enterReturn_stmt(ctx)
        cfgBuilder.createReturnStatement()
    }

    @Override
    void enterRaise_stmt(PythonParser.Raise_stmtContext ctx) {
        super.enterRaise_stmt(ctx)
        cfgBuilder.createStatement(StatementType.RAISE, null, true, JumpTo.METHOD_END)
    }

    @Override
    void exitRaise_stmt(PythonParser.Raise_stmtContext ctx) {
        super.exitRaise_stmt(ctx)
    }

    @Override
    void enterYield_stmt(PythonParser.Yield_stmtContext ctx) {
        super.enterYield_stmt(ctx)
    }

    @Override
    void exitYield_stmt(PythonParser.Yield_stmtContext ctx) {
        super.exitYield_stmt(ctx)
    }

    @Override
    void enterExec_stmt(PythonParser.Exec_stmtContext ctx) {
        super.enterExec_stmt(ctx)
    }

    @Override
    void exitExec_stmt(PythonParser.Exec_stmtContext ctx) {
        super.exitExec_stmt(ctx)
    }

    @Override
    void enterAssert_stmt(PythonParser.Assert_stmtContext ctx) {
        super.enterAssert_stmt(ctx)
    }

    @Override
    void exitAssert_stmt(PythonParser.Assert_stmtContext ctx) {
        super.exitAssert_stmt(ctx)
    }
}
