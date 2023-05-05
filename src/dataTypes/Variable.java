package dataTypes;

import tokentypes.Tokens;

/**
 * @author Samuel Nguyen-Phok
 * Representation of a variable of DimiCore.
 * It can either be constructed as a string or int variable.
 * The Interpreter reads the token type from Token and builds the object.
 */
public class Variable {
    private Tokens type;
    private String string;
    private int integer;

    private Variable(String string, int integer) {
        this.string = string;
        this.integer = integer;
    }

    public Tokens getType() {
        return type;
    }

    public void setType(Tokens type) {
        this.type = type;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public static VariableBuilder builder() {
        return new VariableBuilder();
    }

    public static class VariableBuilder {
        private Tokens type;
        private String string;
        private int integer;

        public VariableBuilder setType(Tokens type) {
            this.type = type;
            return this;
        }

        public VariableBuilder setString(String string) {
            this.string = string;
            return this;
        }

        public VariableBuilder setInteger(int integer) {
            this.integer = integer;
            return this;
        }

        public Variable build() {
            return new Variable(string, integer);
        }
    }
}
