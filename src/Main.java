import fileIntegrityChecker.FileIntegrityChecker;
import interpreter.Interpreter;
import lexer.Lexer;
import lexer.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Interpreter interpreter = Interpreter.getInstance();
        FileIntegrityChecker fileIntegrityChecker = new FileIntegrityChecker(args[0]);
        Lexer lexer = new Lexer(fileIntegrityChecker.getFile());

        while (lexer.hasNextLine()) {
            List<Token> list = lexer.readSingleLine();
            interpreter.interpret(list);
        }

        System.exit(0);
    }
}