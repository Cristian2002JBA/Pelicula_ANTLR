package com.pelicula;

import javax.swing.text.Segment;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMaker;
import org.fife.ui.rsyntaxtextarea.RSyntaxUtilities;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMap;

public class PeliculaTokenMaker extends AbstractTokenMaker {

    // Definimos el resaltado de sintaxis (colores) para las palabras clave de Película
    @Override
    public TokenMap getWordsToHighlight() {
        TokenMap tokenMap = new TokenMap();
        
        tokenMap.put("premiere", Token.RESERVED_WORD);
        tokenMap.put("cast", Token.RESERVED_WORD);
        tokenMap.put("star", Token.RESERVED_WORD);
        tokenMap.put("ticket", Token.DATA_TYPE);
        tokenMap.put("rating", Token.DATA_TYPE);
        tokenMap.put("script", Token.DATA_TYPE);
        tokenMap.put("spoiler", Token.DATA_TYPE);
        tokenMap.put("hit", Token.LITERAL_BOOLEAN);
        tokenMap.put("flop", Token.LITERAL_BOOLEAN);
        tokenMap.put("subtitle", Token.FUNCTION);
        tokenMap.put("audition", Token.FUNCTION);
        tokenMap.put("plot_twist", Token.RESERVED_WORD);
        tokenMap.put("spin_off", Token.RESERVED_WORD);
        tokenMap.put("alternate_ending", Token.RESERVED_WORD);
        tokenMap.put("replay", Token.RESERVED_WORD);
        
        return tokenMap;
    }

    @Override
    public void addToken(Segment segment, int start, int end, int tokenType, int startOffset) {
        if (tokenType == Token.IDENTIFIER) {
            int value = wordsToHighlight.get(segment, start, end);
            if (value != -1) {
                tokenType = value;
            }
        }
        super.addToken(segment, start, end, tokenType, startOffset);
    }

    @Override
    public Token getTokenList(Segment text, int initialTokenType, int startOffset) {
        resetTokenList();
        char[] array = text.array;
        int offset = text.offset;
        int count = text.count;
        int end = offset + count;
        int newStartOffset = startOffset - offset;
        int currentTokenStart = offset;
        int currentTokenType = initialTokenType;

        for (int i = offset; i < end; i++) {
            char c = array[i];
            switch (currentTokenType) {
                case Token.NULL:
                    currentTokenStart = i;
                    if (RSyntaxUtilities.isLetter(c)) {
                        currentTokenType = Token.IDENTIFIER;
                    } else if (Character.isDigit(c)) {
                        currentTokenType = Token.LITERAL_NUMBER_DECIMAL_INT;
                    } else if (c == '"') {
                        currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                    } else if (c == '/') {
                        if (i < end - 1 && array[i+1] == '/') {
                            currentTokenType = Token.COMMENT_EOL;
                        } else if (i < end - 1 && array[i+1] == '*') {
                            currentTokenType = Token.COMMENT_MULTILINE;
                        } else {
                            addToken(text, currentTokenStart, i, Token.OPERATOR, newStartOffset + currentTokenStart);
                            currentTokenType = Token.NULL;
                        }
                    } else if (RSyntaxUtilities.isWhitespace(c)) {
                        currentTokenType = Token.WHITESPACE;
                    } else {
                        addToken(text, currentTokenStart, i, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                        currentTokenType = Token.NULL;
                    }
                    break;
                case Token.WHITESPACE:
                    if (!RSyntaxUtilities.isWhitespace(c)) {
                        addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                        currentTokenStart = i;
                        if (RSyntaxUtilities.isLetter(c)) {
                            currentTokenType = Token.IDENTIFIER;
                        } else if (Character.isDigit(c)) {
                            currentTokenType = Token.LITERAL_NUMBER_DECIMAL_INT;
                        } else if (c == '"') {
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                        } else if (c == '/') {
                            if (i < end - 1 && array[i+1] == '/') {
                                currentTokenType = Token.COMMENT_EOL;
                            } else if (i < end - 1 && array[i+1] == '*') {
                                currentTokenType = Token.COMMENT_MULTILINE;
                            } else {
                                addToken(text, currentTokenStart, i, Token.OPERATOR, newStartOffset + currentTokenStart);
                                currentTokenType = Token.NULL;
                            }
                        } else {
                            addToken(text, currentTokenStart, i, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenType = Token.NULL;
                        }
                    }
                    break;
                case Token.IDENTIFIER:
                    if (!RSyntaxUtilities.isLetterOrDigit(c) && c != '_') {
                        addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                        currentTokenStart = i;
                        currentTokenType = Token.NULL;
                        i--; // Re-process this char
                    }
                    break;
                case Token.LITERAL_NUMBER_DECIMAL_INT:
                    if (!Character.isDigit(c) && c != '.') {
                        addToken(text, currentTokenStart, i - 1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                        currentTokenStart = i;
                        currentTokenType = Token.NULL;
                        i--; // Re-process this char
                    }
                    break;
                case Token.LITERAL_STRING_DOUBLE_QUOTE:
                    if (c == '"') {
                        addToken(text, currentTokenStart, i, Token.LITERAL_STRING_DOUBLE_QUOTE, newStartOffset + currentTokenStart);
                        currentTokenType = Token.NULL;
                    }
                    break;
                case Token.COMMENT_EOL:
                    i = end - 1;
                    addToken(text, currentTokenStart, i, Token.COMMENT_EOL, newStartOffset + currentTokenStart);
                    currentTokenType = Token.NULL;
                    break;
                case Token.COMMENT_MULTILINE:
                    if (c == '*' && i < end - 1 && array[i+1] == '/') {
                        i++;
                        addToken(text, currentTokenStart, i, Token.COMMENT_MULTILINE, newStartOffset + currentTokenStart);
                        currentTokenType = Token.NULL;
                    }
                    break;
            }
        }
        if (currentTokenType != Token.NULL) {
            addToken(text, currentTokenStart, end - 1, currentTokenType, newStartOffset + currentTokenStart);
        }
        addNullToken();
        return firstToken;
    }
}
