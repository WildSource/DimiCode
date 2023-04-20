import FileIntegrityChecker.FileIntegrityChecker;
import lexer.Lexer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Lexer(new FileIntegrityChecker(args[0]).getFile());

    }
}