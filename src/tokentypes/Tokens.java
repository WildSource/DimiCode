package tokentypes;

/**
 * @author Samuel Nguyen-Phok (WildSource)
 * @version 0.0.1
 *
 * These are every possible type a token can possibly be
 *
 */
public enum Tokens {
    OPERATOR(3), INT(2), STRING(2), VARIABLE(1), KEYWORD(0);

    private final int parseOrder;

    private Tokens(int parseOrder) {
        this.parseOrder = parseOrder;
    }

    public int getParseOrder() {
        return parseOrder;
    }

}
