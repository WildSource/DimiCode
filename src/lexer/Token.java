package lexer;

import tokentypes.Tokens;

import java.util.Objects;

/**
 * @author Samuel Nguyen-Phok
 * @version 0.0.1
 * <p>
 * This class represents the tokenized words
 */
public class Token implements Comparable<Token> {
    private String word;

    private Tokens type;

    public Token(String word) {
        attribTokenTypeToWord(word);
        if (this.type == Tokens.STRING && word.contains("_" ) || this.type == Tokens.STRING && word.contains("\"" )) {
            String modifiedString;
            modifiedString = word.replace("_", " " ).replace("\"", "" );
            this.word = modifiedString;
        } else {
            this.word = word;
        }
    }

    private void attribTokenTypeToWord(String word) {
        // Check if the word matches the pattern of a number
        if (word.matches("-?\\d+(\\.\\d+)?" )) {
            this.type = Tokens.INT;
        }
        // Check if the word matches the pattern of a string
        else if (word.matches("\".*\"" )) {
            this.type = Tokens.STRING;
        }
        // Check if the word is a keyword, operator, or punctuation
        else {
            switch (word) {
                case "string" -> this.type = Tokens.STRINGKEYWORD;
                case "int" -> this.type = Tokens.INTKEYWORD;
                case "if", "while", "else", "print" -> this.type = Tokens.KEYWORD;
                case "+", "*", "-", "/", "=", "<", ">" -> this.type = Tokens.OPERATOR;
                default -> this.type = Tokens.VARIABLE;
            }
        }
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Tokens getType() {
        return type;
    }

    public void setType(Tokens type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Token{" +
                "word='" + word + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public int compareTo(Token o) {
        Objects.requireNonNull(o);

        int compareValue = 0;

        int thisParseOrder = this.type.getParseOrder();
        int objectParseOrder = o.getType().getParseOrder();

        if (thisParseOrder > objectParseOrder) {
            compareValue = 1;
        } else if (thisParseOrder < objectParseOrder) {
            compareValue = -1;
        }
        return compareValue;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEquals = false;
        if (o instanceof Token token) {
            if (this.type == token.getType() && this.word.equals(token.getWord())) {
                isEquals = true;
            }
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, type);
    }
}
