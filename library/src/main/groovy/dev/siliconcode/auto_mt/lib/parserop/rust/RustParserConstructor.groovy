package dev.siliconcode.auto_mt.lib.parserop.rust

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.rust.RustLexer
import dev.siliconcode.auto_mt.parsers.rust.RustParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class RustParserConstructor implements ParserConstructor {

    synchronized RustParser loadFile(final String file) throws IOException {
        final RustLexer lexer = new RustLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new RustParser(tokens)
    }
}
