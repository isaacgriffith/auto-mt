package dev.siliconcode.auto_mt.lib.parserop.objc

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.objc.ObjectiveCLexer
import dev.siliconcode.auto_mt.parsers.objc.ObjectiveCParser
import dev.siliconcode.auto_mt.parsers.objc.ObjectiveCPreprocessorParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class ObjCParserConstructor implements ParserConstructor {

    synchronized ObjectiveCParser loadFile(final String file) throws IOException {
        final ObjectiveCLexer lexer = new ObjectiveCLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        final ObjectiveCPreprocessorParser preparser = new ObjectiveCPreprocessorParser(tokens)
        return new ObjectiveCParser(preparser.getTokenStream())
    }
}
