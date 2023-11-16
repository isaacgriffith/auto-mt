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
package dev.siliconcode.auto_mt.lib.parserop.c

import dev.siliconcode.auto_mt.lib.code.Project
import dev.siliconcode.auto_mt.lib.parserop.ArtifactIdentifierRegistrar
import dev.siliconcode.auto_mt.lib.parserop.BaseDirector
import dev.siliconcode.auto_mt.lib.parserop.ModelBuilder
import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.c.CParser
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ParseTreeListener

class CDirector extends BaseDirector {

    CDirector(Project proj, boolean statements = true, boolean useSinglePass = false, boolean createCFG = true, boolean useExpressions = false) {
        super(proj, ArtifactIdentifierRegistrar.instance.getArtifactIdentifier('c'), statements, useSinglePass, createCFG, useExpressions)
    }

    @Override
    ParseTreeListener createStatementExtractor(ModelBuilder builder) {
        return new CStatementExtractor(builder)
    }

    @Override
    ParseTreeListener createFileAndTypeExtractor(ModelBuilder builder) {
        return new CFileAndTypeExtractor(builder)
    }

    @Override
    ParserConstructor createParserConstructor() {
        return new CParserConstructor()
    }

    @Override
    ParserRuleContext getRootContext(Parser parser) {
        if (!(parser instanceof CParser)) {
            throw new IllegalArgumentException("Parser must be of type CParser")
        }

        return ((CParser) parser).compilationUnit()
    }
}
