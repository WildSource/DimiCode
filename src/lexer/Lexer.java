package lexer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Samuel Nguyen-Phok
 * @version 0.0.1
 * <p>
 * This class read a file provided by the FileIntegrityChecker who has verified that the file works, tokenize every word and puts a label on them from the tokens enum.
 */
public class Lexer {
    private File file;

    private Scanner reader;

    public Lexer(File pFile) throws Exception {
        this.file = pFile;
        this.reader = new Scanner(file);
    }

    public List<Token> readSingleLine() {
        ArrayList<Token> tokenList = new ArrayList<Token>();

        if (reader.hasNextLine()) {
            String line = reader.nextLine();
            Scanner lineReader = new Scanner(line);
            while (lineReader.hasNext()) {
                tokenList.add(new Token(lineReader.next()));
            }
        }

        Collections.sort(tokenList);
        return tokenList;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Scanner getReader() {
        return reader;
    }

    public void setReader(Scanner reader) {
        this.reader = reader;
    }
}
