package utils;

public class InterpreterUtils {
    private static InterpreterUtils instance;

    private InterpreterUtils() {
    }

    public InterpreterUtils getInstance() {
        if (instance == null) {
            instance = new InterpreterUtils();
        }
        return instance;
    }
}
