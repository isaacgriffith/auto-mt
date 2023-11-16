package dev.siliconcode.auto_mt.lib.parserop


import org.antlr.v4.runtime.Parser

interface ParserConstructor {

    abstract Parser loadFile(final String file) throws IOException
}
