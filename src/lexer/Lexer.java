package lexer;

import java.io.File;

/**
 * @author Samuel Nguyen-Phok
 * @version 0.0.1
 * <p>
 * This class read a file, tokenize every word and puts a label on it from the tokens enum.
 */
public class Lexer {
    private File file;

    public Lexer(String fileName) throws Exception {
        this.file = new File(fileName);
        verifyFileExist(this.file);
        verifyFileExtensions(this.file);
    }

    private void verifyFileExist(File file) throws Exception {
        if (!file.exists()) {
            throw new Exception("File does not exist");
        } else {
            System.out.println("File reference created");
        }
    }

    private void verifyFileExtensions(File file) throws Exception {
        if (file.getName().endsWith(".dc")) {
            System.out.println("File type verified");
        } else {
            throw new Exception("Wrong file type since it does not end with \".dc\" ");
        }

    }
}
