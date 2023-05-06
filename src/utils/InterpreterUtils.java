package utils;

import dataTypes.Variable;
import lexer.Token;
import tokentypes.Tokens;

import java.util.List;

/**
 * @author Samuel Nguyen-Phok
 * @version 0.0.1
 * <p>
 * This class holds the implementations and utility methods for the interpreter's operations
 */
public class InterpreterUtils {
    private static InterpreterUtils instance;

    private InterpreterUtils() {
    }

    public Variable createVariable(Tokens type, String value) {
        return Variable.builder().setString(value).setType(type).build();
    }

    public Variable createVariable(Tokens type, int value) {
        return Variable.builder().setInteger(value).setType(type).build();
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
