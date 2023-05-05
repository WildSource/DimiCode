package interpreter;

import dataTypes.Variable;
import lexer.Token;
import tokentypes.Tokens;

import java.util.HashMap;
import java.util.List;

public final class Interpreter {
    private static Interpreter instance;

    private static HashMap<Long, Variable> memory;

    private Interpreter() {
        memory = new HashMap<>();
    }

    public static void interpret(List<Token> tokens) {

        for (Token token : tokens) {
            if (token.getType() == Tokens.VARIABLE) {

            }
        }
    }

    public static Interpreter getInstance() {
        if (instance == null) {
            instance = new Interpreter();
        }
        return instance;
    }
}
