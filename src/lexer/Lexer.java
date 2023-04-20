package lexer;

import java.io.File;

/**
 * @author Samuel Nguyen-Phok
 * @version 0.0.1
 *
 * This class read a file, tokenize every word and puts a label on it from the tokens enum.
 *
 */
public class Lexer {
    private File file;

    public Lexer(String fileName) {
        this.file = new File(fileName);
    }
}
