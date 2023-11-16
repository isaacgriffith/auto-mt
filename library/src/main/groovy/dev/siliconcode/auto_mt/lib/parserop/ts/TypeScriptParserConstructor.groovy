package dev.siliconcode.auto_mt.lib.parserop.ts

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.ts.TypeScriptLexer
import dev.siliconcode.auto_mt.parsers.ts.TypeScriptParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class TypeScriptParserConstructor implements ParserConstructor {

    synchronized TypeScriptParser loadFile(final String file) throws IOException {
        final TypeScriptLexer lexer = new TypeScriptLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new TypeScriptParser(tokens)
    }
}
