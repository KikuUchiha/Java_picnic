import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
    private File file;

    public WordCounter(File file) {
        this.file = file;
    }
    //считает количество слов в файле
    public int countWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int count = 0;
        while (scanner.hasNext()) {
            scanner.next();
            count++;
        }
        scanner.close();
        return count;
    }

}
