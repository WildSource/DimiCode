package fileIntegrityChecker;

import java.io.File;

/**
 * @author Samuel Nguyen-Phok
 * @version 0.0.1
 * <p>
 * This class verifies a bunch of properties before allowing it to be tokenized by the lexer.
 * It is also the first step of the interpreter and acts as a bouncer to avoid working on a file that does not exist or the wrong type of file.
 */
public class FileIntegrityChecker {
    private File file;

    public FileIntegrityChecker(String fileName) throws Exception {
        this.file = new File(fileName);
        verifyFileExist(this.file);
        verifyFileExtension(this.file);
    }

    private void verifyFileExist(File file) throws Exception {
        if (!file.exists()) {
            throw new Exception("File does not exist");
        } else {
            System.out.println("File reference created");
        }
    }

    private void verifyFileExtension(File file) throws Exception {
        if (file.getName().endsWith(".dc")) {
            System.out.println("File type verified");
        } else {
            throw new Exception("Wrong file type since it does not end with \".dc\" ");
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
