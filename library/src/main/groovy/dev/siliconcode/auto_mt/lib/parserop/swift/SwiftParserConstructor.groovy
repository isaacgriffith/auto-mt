package dev.siliconcode.auto_mt.lib.parserop.swift

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.swift.Swift5Lexer
import dev.siliconcode.auto_mt.parsers.swift.Swift5Parser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class SwiftParserConstructor implements ParserConstructor {

    synchronized Swift5Parser loadFile(final String file) throws IOException {
        final Swift5Lexer lexer = new Swift5Lexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new Swift5Parser(tokens)
    }
}
