package dev.siliconcode.auto_mt.lib.parserop.r

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.r.RFilter
import dev.siliconcode.auto_mt.parsers.r.RLexer
import dev.siliconcode.auto_mt.parsers.r.RParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class RParserConstructor implements ParserConstructor {

    synchronized RParser loadFile(final String file) throws IOException {
        final RLexer lexer = new RLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        final RFilter filter = new RFilter(tokens)
        filter.stream()
        tokens.seek(0)
        return new RParser(tokens)
    }
}
