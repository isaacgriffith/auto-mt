package dev.siliconcode.auto_mt.lib.parserop.js

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.js.JavaScriptLexer
import dev.siliconcode.auto_mt.parsers.js.JavaScriptParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class JavaScriptParserConstructor implements ParserConstructor {

    synchronized JavaScriptParser loadFile(final String file) throws IOException {
        final JavaScriptLexer lexer = new JavaScriptLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new JavaScriptParser(tokens)
    }
}
