import fileIntegrityChecker.FileIntegrityChecker;
import lexer.Lexer;
import lexer.Token;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        FileIntegrityChecker fileIntegrityChecker = new FileIntegrityChecker(args[0]);
        Lexer lexer = new Lexer(fileIntegrityChecker.getFile());
        List<Token> list = lexer.readSingleLine();
        Collections.sort(list);
        for (Token token : list) {
            System.out.println(token.toString());
        }
        System.exit(0);
    }
}