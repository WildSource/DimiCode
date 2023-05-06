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
        Token varConditionAssign = new Token("=");

        if (tokens.contains(varConditionAssign)) {
            assignment(tokens);
        }
    }

    private void assignment(List<Token> tokens) {
        Token varConditionInt = new Token("int");
        Token varConditionString = new Token("string");
        if (tokens.contains(varConditionString)) {
            createStringVar(tokens);
        }
        if (tokens.contains(varConditionInt)) {
            createIntVar(tokens);
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
        int value = utils.findIntValue(tokens);
        allocateVariable(varName, utils.createVariable(Tokens.INT, value));
    }

    public static Interpreter getInstance() {
        if (instance == null) {
            instance = new Interpreter();
        }
        return instance;
    }
}
