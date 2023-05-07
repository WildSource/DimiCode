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
        for (Token token : list) {
            if (token.getType() == Tokens.VARIABLE) {
                return token.getWord();
            }
        }
        return "";
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
            if (token.getType() == Tokens.INT) {
                value = Integer.parseInt(token.getWord());
            }
        }
        return value;
    }

    /**
     * Finds any value in the token list wether it is a string or a integer.
     * As long as it is a value it will be returned
     *
     * @param list tokens from the lexer
     * @return Variable object that acts as Either like in Haskell
     */
    public Variable findValue(List<Token> list) {
        int integerValue = 0;
        String stringValue = "String value not found";
        for (Token token : list) {
            if (token.getType() == Tokens.INT) {
                integerValue = Integer.parseInt(token.getWord());
            } else if (token.getType() == Tokens.STRING) {
                stringValue = token.getWord();
            }
        }
        return Variable.builder().setInteger(integerValue).setString(stringValue).build();
    }

    public static InterpreterUtils getInstance() {
        if (instance == null) {
            instance = new InterpreterUtils();
        }
        return instance;
    }
}
