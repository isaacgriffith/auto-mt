package dev.siliconcode.auto_mt.lib.parserop.scala

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.scala.ScalaLexer
import dev.siliconcode.auto_mt.parsers.scala.ScalaParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class ScalaParserConstructor implements ParserConstructor {

    synchronized ScalaParser loadFile(final String file) throws IOException {
        final ScalaLexer lexer = new ScalaLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new ScalaParser(tokens)
    }
}
