package dev.siliconcode.auto_mt.lib.parserop.dart

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.dart.Dart2Lexer
import dev.siliconcode.auto_mt.parsers.dart.Dart2Parser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Parser

class DartParserConstructor implements ParserConstructor {

    @Override
    synchronized Parser loadFile(String file) throws IOException {
        final Dart2Lexer lexer = new Dart2Lexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new Dart2Parser(tokens)
    }
}
