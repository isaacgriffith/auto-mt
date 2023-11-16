package dev.siliconcode.auto_mt.lib.parserop.php

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.php.PhpLexer
import dev.siliconcode.auto_mt.parsers.php.PhpParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class PHPParserConstructor implements ParserConstructor {

    synchronized PhpParser loadFile(final String file) throws IOException {
        final PhpLexer lexer = new PhpLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new PhpParser(tokens)
    }
}
