package dev.siliconcode.auto_mt.lib.parserop.java

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.java.Java20Lexer
import dev.siliconcode.auto_mt.parsers.java.Java20Parser
import dev.siliconcode.auto_mt.parsers.univ_python.PythonParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class JavaParserConstructor implements ParserConstructor {

    @Override
    synchronized PythonParser loadFile(final String file) throws IOException {
        final Java20Lexer lexer = new Java20Lexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new Java20Parser(tokens)
    }
}
