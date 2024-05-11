import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
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

    //находит самое длинное слово в файле
    public String findLongestWord() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String longestWord = "";
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        scanner.close();
        return longestWord;
    }
    //частота каждого слова в файле
    public Map<String, Integer> wordFrequency() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Map<String, Integer> frequencyMap = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        scanner.close();
        return frequencyMap;
    }

}
