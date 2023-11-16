package dev.siliconcode.auto_mt.lib.parserop.c

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.c.CLexer
import dev.siliconcode.auto_mt.parsers.c.CParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class CParserConstructor implements ParserConstructor {

    synchronized CParser loadFile(final String file) throws IOException {
        final CLexer lexer = new CLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new CParser(tokens)
    }
}
