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

import dev.siliconcode.auto_mt.lib.code.TypeType
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.parsers.univ_python.PythonParser
import dev.siliconcode.auto_mt.parsers.univ_python.PythonParser.FuncdefContext
import dev.siliconcode.auto_mt.parsers.univ_python.PythonParserBaseListener
import org.antlr.v4.runtime.tree.TerminalNode

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
abstract class PythonAbstractExtractor extends PythonParserBaseListener {

    private ModelBuilder modelBuilder

    PythonAbstractExtractor(ModelBuilder builder) {
        this.modelBuilder = builder
    }

    protected String createSignature(TerminalNode identifier, PythonParser.TypedargslistContext argsListContext) {
        StringBuilder builder = new StringBuilder();
        builder.append(identifier.getText());
        builder.append("(");

        int numParams = 0
        if (argsListContext) {
            if (argsListContext.def_parameters()) {
                numParams += argsListContext.def_parameters().size()
            }

            if (argsListContext.kwargs()) {
                numParams += 1
            }

            if (argsListContext.args()) {
                numParams += 1
            }
        }

        return "${identifier.getText()} (${numParams})"
    }

    @Override
    void enterClassdef(PythonParser.ClassdefContext ctx) {
        modelBuilder.findOrCreateType(ctx.name()?.NAME()?.getText(), TypeType.CLASS)

        super.enterClassdef(ctx)
    }

    @Override
    void exitClassdef(PythonParser.ClassdefContext ctx) {
        modelBuilder.endType()

        super.exitClassdef(ctx)
    }

    @Override
    void enterFuncdef(FuncdefContext ctx) {
        String signature = createSignature(ctx.name()?.NAME(), ctx.typedargslist())

        modelBuilder.findMethod(signature)

        super.enterFuncdef(ctx)
    }

    @Override
    void exitFuncdef(FuncdefContext ctx) {
        modelBuilder.finishMethod()

        super.exitFuncdef(ctx)
    }
}
