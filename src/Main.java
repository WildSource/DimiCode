import fileIntegrityChecker.FileIntegrityChecker;
import interpreter.Interpreter;
import lexer.Lexer;
import lexer.Token;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        FileIntegrityChecker fileIntegrityChecker = new FileIntegrityChecker(args[0]);
        Lexer lexer = new Lexer(fileIntegrityChecker.getFile());
        List<Token> list = lexer.readSingleLine();
        for (Token token: list ) {
            System.out.println(token);
        }
        //Interpreter.interpret(list);
        System.exit(0);
    }
}