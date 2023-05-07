package interpreter;

import dataTypes.Variable;
import lexer.Token;
import tokentypes.Tokens;
import utils.InterpreterUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author Samuel Nguyen-Phok
 * @version 0.0.1
 * <p>
 * This class is the engine of the interpreter.
 * It is the brain of the interpreter.
 */
public final class Interpreter {
    private static Interpreter instance;

    private static InterpreterUtils utils;

    private static HashMap<String, Variable> memory;

    private Interpreter() {
        utils = InterpreterUtils.getInstance();
        memory = new HashMap<>();
    }

    public void interpret(List<Token> tokens) {
        Token varConditionAssign = new Token("=" );
        Token varConditionPrint = new Token("print" );

        if (tokens.contains(varConditionAssign)) {
            assignment(tokens);
        }

        if (tokens.contains(varConditionPrint)) {
            output(tokens);
        }
    }

    private void assignment(List<Token> tokens) {
        Token varConditionInt = new Token("int" );
        Token varConditionString = new Token("string" );
        if (tokens.contains(varConditionString)) {
            createStringVar(tokens);
        }
        if (tokens.contains(varConditionInt)) {
            createIntVar(tokens);
        }
    }

    private void output(List<Token> tokens) {
        String varName = utils.findVarName(tokens);
        Variable value = memory.get(varName);
        if (value.getType() == Tokens.INT) {
            System.out.println(value.getInteger());
        } else if (value.getType() == Tokens.STRING) {
            System.out.println(value.getString());
        }
    }

    private Variable getVariable(String varName) {
        return memory.get(varName);
    }

    private void allocateVariable(String varName, Variable variable) {
        memory.put(varName, variable);
    }

    private void deallocateVariable(String varName) {
        memory.remove(varName);
    }

    private void createStringVar(List<Token> tokens) {
        String varName = utils.findVarName(tokens);
        String value = utils.findStringValue(tokens);
        allocateVariable(varName, utils.createVariable(Tokens.STRING, value));
    }

    private void createIntVar(List<Token> tokens) {
        String varName = utils.findVarName(tokens);
        boolean containsOperator = tokens.stream().anyMatch(token -> token.getType() == Tokens.OPERATOR);

        if (containsOperator) {
            Token token = utils.findOperator(tokens);
            int value1 = utils.findIntValue(tokens);
            int value2 = utils.findIntValue(tokens);
            int result = 0;
            switch (token.getWord()) {
                case "+" -> result = value1 + value2;
                case "-" -> result = value1 - value2;
                case "*" -> result = value1 * value2;
                case "/" -> result = value1 / value2;
            }
            allocateVariable(varName, Variable.builder().setInteger(result).setType(Tokens.INT).build());
        } else {
            int value = utils.findIntValue(tokens);
            allocateVariable(varName, utils.createVariable(Tokens.INT, value));
        }
    }

    public static Interpreter getInstance() {
        if (instance == null) {
            instance = new Interpreter();
        }
        return instance;
    }
}
