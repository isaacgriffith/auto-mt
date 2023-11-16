package dev.siliconcode.auto_mt.lib.parserop.csharp

import dev.siliconcode.auto_mt.lib.parserop.ParserConstructor
import dev.siliconcode.auto_mt.parsers.csharp.CSharpLexer
import dev.siliconcode.auto_mt.parsers.csharp.CSharpParser
import dev.siliconcode.auto_mt.parsers.csharp.CSharpPreprocessorParser
import groovy.util.logging.Slf4j
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.ListTokenSource
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.Token

@Slf4j
class CSharpParserConstructor implements ParserConstructor {

    synchronized CSharpParser loadFile(final String file) throws IOException {
        List<Token> codeTokens = [];
        List<Token> commentTokens = [];

        Lexer preprocessorLexer = new CSharpLexer(CharStreams.fromFileName(file));
        // Collect all tokens with lexer (CSharpLexer.g4).
        var tokens = preprocessorLexer.getAllTokens();
        var directiveTokens = [];
        ListTokenSource directiveTokenSource = new ListTokenSource(directiveTokens);
        var directiveTokenStream = new CommonTokenStream(directiveTokenSource, CSharpLexer.DIRECTIVE);
        CSharpPreprocessorParser preprocessorParser = new CSharpPreprocessorParser(directiveTokenStream);

        int index = 0;
        boolean compiledTokens = true;
        while (index < tokens.size()) {
            var token = tokens[index];
            if (token.type == CSharpLexer.SHARP) {
                directiveTokens.clear();
                int directiveTokenIndex = index + 1;
                // Collect all preprocessor directive tokens.
                while (directiveTokenIndex < tokens.size() &&
                        tokens[directiveTokenIndex].type != CSharpLexer.EOF &&
                        tokens[directiveTokenIndex].type != CSharpLexer.DIRECTIVE_NEW_LINE &&
                        tokens[directiveTokenIndex].type != CSharpLexer.SHARP) {
                    if (tokens[directiveTokenIndex].getChannel() == CSharpLexer.COMMENTS_CHANNEL) {
                        commentTokens.add(tokens[directiveTokenIndex]);
                    }
                    else if (tokens[directiveTokenIndex].getChannel() != Lexer.isHidden()) {
                        directiveTokens.add(tokens[directiveTokenIndex]);
                    }
                    directiveTokenIndex++;
                }

                directiveTokenSource = new ListTokenSource(directiveTokens);
                directiveTokenStream = new CommonTokenStream(directiveTokenSource, CSharpLexer.DIRECTIVE);
                preprocessorParser.setInputStream(directiveTokenStream);
                preprocessorParser.reset();
                // Parse condition in preprocessor directive (based on CSharpPreprocessorParser.g4 grammar).
                CSharpPreprocessorParser.Preprocessor_directiveContext directive = preprocessorParser.preprocessor_directive();
                // if true than next code is valid and not ignored.
                compiledTokens = directive.value;
                index = directiveTokenIndex - 1;
            }
            else if (token.channel == CSharpLexer.COMMENTS_CHANNEL)
            {
                commentTokens.add(token); // Collect comment tokens (if required).
            }
            else if (token.getChannel() != Lexer.hidden && token.getType() != CSharpLexer.DIRECTIVE_NEW_LINE && compiledTokens)
            {
                codeTokens.add(token); // Collect code tokens.
            }
            index++;
        }

        // At second stage tokens parsed in usual way.
        var codeTokenSource = new ListTokenSource(tokens);
        var codeTokenStream = new CommonTokenStream(codeTokenSource);
        CSharpParser parser =  new CSharpParser(codeTokenStream);
        parser.removeErrorListeners()
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                log.error "Syntax error in file: $file at line: $line:$charPositionInLine: $msg"
            }
        })
        return parser
    }
}