package lexer;

import java.io.File;

/**
 * @author Samuel Nguyen-Phok
 * @version 0.0.1
 * <p>
 * This class read a file provided by the FileIntegrityChecker who has verified that the file works, tokenize every word and puts a label on them from the tokens enum.
 */
public class Lexer {
    private File file;

    public Lexer(String fileName) throws Exception {
        this.file = new File(fileName);
    }
}
