package dev.siliconcode.auto_mt.lib.parserop.go

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.go.GoLexer
import dev.siliconcode.auto_mt.parsers.go.GoParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class GoParserConstructor implements ParserConstructor {

    synchronized GoParser loadFile(final String file) throws IOException {
        final GoLexer lexer = new GoLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new GoParser(tokens)
    }
}
