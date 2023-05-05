package interpreter;

import dataTypes.Variable;
import lexer.Token;
import tokentypes.Tokens;

import java.util.HashMap;
import java.util.List;

public final class Interpreter {
    private static Interpreter instance;

    private static Long memoryIndexLenght;

    private static HashMap<Long, Variable> memory;

    private Interpreter() {
        memory = new HashMap<>();
        memoryIndexLenght = 0L;
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

    private void allocateVariable(Variable variable) {
        memory.put(getMemoryIndexLenght(), variable);
    }

    private void deallocateVariable(Long memoryIndex) {
        memory.remove(memoryIndex);
    }

    private Variable createVariable(Tokens type, String value) {
        return Variable.builder().setString(value).setType(type).build();
    }

    private Variable createVariable(Tokens type, int value) {
        return Variable.builder().setInteger(value).setType(type).build();
    }

    public static Interpreter getInstance() {
        if (instance == null) {
            instance = new Interpreter();
        }
        return instance;
    }

    public static Long getMemoryIndexLenght() {
        return memoryIndexLenght;
    }

    public static void incrementMemoryIndexLenght() {
        Interpreter.memoryIndexLenght++;
    }
}
