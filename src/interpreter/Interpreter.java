package interpreter;

import dataTypes.Variable;
import lexer.Token;
import tokentypes.Tokens;

import java.util.HashMap;
import java.util.List;


public final class Interpreter {
    private static Interpreter instance;

    private static HashMap<String, Variable> memory;

    private Interpreter() {
        memory = new HashMap<>();
    }

    private void interpret(List<Token> tokens) {
        Token varConditionAssign = new Token("=");

        if (tokens.contains(varConditionAssign)) {
            assignment(tokens);
        }
    }

    private void assignment(List<Token> tokens) {
        Token varConditionInt = new Token("int");
        Token varConditionString = new Token("string");
        if (tokens.contains(varConditionString)) {
            String varName = findVarName(tokens);
            String value = findStringValue(tokens);
            allocateVariable(varName, Variable.builder().setType(Tokens.STRING).setString(value).build());
        }
        if (tokens.contains(varConditionInt)) {
            String varName = findVarName(tokens);
            int value = findIntValue(tokens);
            allocateVariable(varName, Variable.builder().setType(Tokens.INT).setInteger(value).build());
        }
    }

    private Variable add(Variable val1, Variable val2) {
        int result = val1.getInteger() + val2.getInteger();
        return Variable.builder().setInteger(result).build();
    }

    private Variable subtract(Variable val1, Variable val2) {
        int result = val1.getInteger() - val2.getInteger();
        return Variable.builder().setInteger(result).build();
    }

    private Variable multiply(Variable val1, Variable val2) {
        int result = val1.getInteger() * val2.getInteger();
        return Variable.builder().setInteger(result).build();
    }

    private Variable divide(Variable val1, Variable val2) {
        int result = val1.getInteger() / val2.getInteger();
        return Variable.builder().setInteger(result).build();
    }

    private Variable getVariable(Long memoryIndex) {
        return memory.get(memoryIndex);
    }

    private void allocateVariable(String varName, Variable variable) {
        memory.put(varName, variable);
    }

    private void deallocateVariable(String varName) {
        memory.remove(varName);
    }

    private Variable createVariable(Tokens type, String value) {
        return Variable.builder().setString(value).setType(type).build();
    }

    private Variable createVariable(Tokens type, int value) {
        return Variable.builder().setInteger(value).setType(type).build();
    }

    private String findVarName(List<Token> list) {
        String varName = "";
        for (Token token : list) {
            if (token.getType() == Tokens.VARIABLE) {
                varName = token.getWord();
            }
        }
        return varName;
    }

    private String findStringValue(List<Token> list) {
        String value = "";
        for (Token token : list) {
            if (token.getType() == Tokens.STRING) {
                value = token.getWord();
            }
        }
        return value;
    }

    private int findIntValue(List<Token> list) {
        int value = 0;
        for (Token token : list) {
            if (token.getType() == Tokens.STRING) {
                value = Integer.parseInt(token.getWord());
            }
        }
        return value;
    }

    public static Interpreter getInstance() {
        if (instance == null) {
            instance = new Interpreter();
        }
        return instance;
    }
}
