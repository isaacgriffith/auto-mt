package dev.siliconcode.auto_mt.lib.parserop.ruby

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.ruby.CorundumLexer
import dev.siliconcode.auto_mt.parsers.ruby.CorundumParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class RubyParserConstructor implements ParserConstructor {

    synchronized CorundumParser loadFile(final String file) throws IOException {
        final CorundumLexer lexer = new CorundumLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new CorundumParser(tokens)
    }
}
