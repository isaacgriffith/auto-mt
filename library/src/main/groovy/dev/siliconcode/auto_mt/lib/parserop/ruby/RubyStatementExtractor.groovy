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
package dev.siliconcode.auto_mt.lib.parserop.ruby

import dev.siliconcode.auto_mt.lib.parserop.CFGStatementHandler
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.ruby.CorundumParser

class RubyStatementExtractor extends RubyAbstractExtractor implements CFGStatementHandler {

    RubyStatementExtractor(ModelBuilder builder) {
        super(builder)
        this.modelBuilder = builder
    }

    @Override
    void enterFunction_definition(CorundumParser.Function_definitionContext ctx) {
        super.enterFunction_definition(ctx)
    }

    @Override
    void exitFunction_definition(CorundumParser.Function_definitionContext ctx) {
        super.exitFunction_definition(ctx)
    }

    @Override
    void enterReturn_statement(CorundumParser.Return_statementContext ctx) {
        super.enterReturn_statement(ctx)
    }

    @Override
    void exitReturn_statement(CorundumParser.Return_statementContext ctx) {
        super.exitReturn_statement(ctx)
    }

    @Override
    void enterElsif_statement(CorundumParser.Elsif_statementContext ctx) {
        super.enterElsif_statement(ctx)
    }

    @Override
    void exitElsif_statement(CorundumParser.Elsif_statementContext ctx) {
        super.exitElsif_statement(ctx)
    }

    @Override
    void enterIf_elsif_statement(CorundumParser.If_elsif_statementContext ctx) {
        super.enterIf_elsif_statement(ctx)
    }

    @Override
    void exitIf_elsif_statement(CorundumParser.If_elsif_statementContext ctx) {
        super.exitIf_elsif_statement(ctx)
    }

    @Override
    void enterIf_statement(CorundumParser.If_statementContext ctx) {
        super.enterIf_statement(ctx)
    }

    @Override
    void exitIf_statement(CorundumParser.If_statementContext ctx) {
        super.exitIf_statement(ctx)
    }

    @Override
    void enterUnless_statement(CorundumParser.Unless_statementContext ctx) {
        super.enterUnless_statement(ctx)
    }

    @Override
    void exitUnless_statement(CorundumParser.Unless_statementContext ctx) {
        super.exitUnless_statement(ctx)
    }

    @Override
    void enterWhile_statement(CorundumParser.While_statementContext ctx) {
        super.enterWhile_statement(ctx)
    }

    @Override
    void exitWhile_statement(CorundumParser.While_statementContext ctx) {
        super.exitWhile_statement(ctx)
    }

    @Override
    void enterFor_statement(CorundumParser.For_statementContext ctx) {
        super.enterFor_statement(ctx)
    }

    @Override
    void exitFor_statement(CorundumParser.For_statementContext ctx) {
        super.exitFor_statement(ctx)
    }

    @Override
    void enterStatement_body(CorundumParser.Statement_bodyContext ctx) {
        super.enterStatement_body(ctx)
    }

    @Override
    void exitStatement_body(CorundumParser.Statement_bodyContext ctx) {
        super.exitStatement_body(ctx)
    }
}
