package utils;

import lexer.Token;
import tokentypes.Tokens;

import java.util.List;

public class InterpreterUtils {
    private static InterpreterUtils instance;

    private InterpreterUtils() {
    }

    public String findVarName(List<Token> list) {
        String varName = "";
        for (Token token : list) {
            if (token.getType() == Tokens.VARIABLE) {
                varName = token.getWord();
            }
        }
        return varName;
    }

    public String findStringValue(List<Token> list) {
        String value = "";
        for (Token token : list) {
            if (token.getType() == Tokens.STRING) {
                value = token.getWord();
            }
        }
        return value;
    }

    public int findIntValue(List<Token> list) {
        int value = 0;
        for (Token token : list) {
            if (token.getType() == Tokens.STRING) {
                value = Integer.parseInt(token.getWord());
            }
        }
        return value;
    }

    public static InterpreterUtils getInstance() {
        if (instance == null) {
            instance = new InterpreterUtils();
        }
        return instance;
    }
}
