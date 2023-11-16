package dev.siliconcode.auto_mt.lib.parserop.python

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.univ_python.PythonLexer
import dev.siliconcode.auto_mt.parsers.univ_python.PythonParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class PythonParserConstructor implements ParserConstructor {

    synchronized PythonParser loadFile(final String file) throws IOException {
        final PythonLexer lexer = new PythonLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new PythonParser(tokens)
    }
}