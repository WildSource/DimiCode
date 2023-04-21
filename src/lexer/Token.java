package lexer;

import tokentypes.Tokens;

/**
 * @author Samuel Nguyen-Phok
 * @version 0.0.1
 * <p>
 * This class represents the tokenized words
 */
public class Token {
    private String word;

    private Tokens type;

    public Token(String word) {
        this.word = word;
        attribTokenTypeToWord(word);
    }

    private void attribTokenTypeToWord(String word) {
        // Check if the word matches the pattern of a number
        if (word.matches("-?\\d+(\\.\\d+)?")) {
            this.type = Tokens.INT;
        }
        // Check if the word matches the pattern of a string
        else if (word.matches("\".*\"")) {
            this.type = Tokens.STRING;
        }
        // Check if the word is a keyword, operator, or punctuation
        else {
            switch (word) {
                case "int", "string", "if", "while", "else" -> this.type = Tokens.KEYWORD;
                case "+", "*", "-", "/", "=", "<", ">" -> this.type = Tokens.OPERATOR;
                case "{" -> this.type = Tokens.BRACKETLEFT;
                case "}" -> this.type = Tokens.BRACKETRIGHT;
                case "(" -> this.type = Tokens.PARENTHESISLEFT;
                case ")" -> this.type = Tokens.PARENTHESISRIGHT;
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
}
