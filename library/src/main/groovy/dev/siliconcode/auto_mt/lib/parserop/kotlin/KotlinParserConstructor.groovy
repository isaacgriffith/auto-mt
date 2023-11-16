package dev.siliconcode.auto_mt.lib.parserop.kotlin

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.kotlin.KotlinLexer
import dev.siliconcode.auto_mt.parsers.kotlin.KotlinParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class KotlinParserConstructor implements ParserConstructor {

    synchronized KotlinParser loadFile(final String file) throws IOException {
        final KotlinLexer lexer = new KotlinLexer(CharStreams.fromFileName(file))
        final CommonTokenStream tokens = new CommonTokenStream(lexer)
        return new KotlinParser(tokens)
    }
}
