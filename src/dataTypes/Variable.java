package dataTypes;

import tokentypes.Tokens;

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

    public class VariableBuilder {
        private String string;
        private int integer;

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
