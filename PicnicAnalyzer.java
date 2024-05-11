import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class PicnicAnalyzer {
    private WordCounter wordCounter;
    private ProductCatalog productCatalog;

    public PicnicAnalyzer(File file) {
        this.wordCounter = new WordCounter(file);
        this.productCatalog = new ProductCatalog();
    }

    public void analyzePicnic() {
        try {
            // Подсчет слов
            int wordCount = wordCounter.countWords();
            System.out.println("Количество слов в файле: " + wordCount);

            // Нахождение самого длинного слова
            String longestWord = wordCounter.findLongestWord();
            System.out.println("Самое длинное слово в файле: " + longestWord);

            // Вычисление частоты слов
            Map<String, Integer> wordFrequency = wordCounter.wordFrequency();
            printWordFrequency(wordFrequency);

            // Подсчет фруктов и овощей
            int fruitCount = calculateTotalProductCount(wordFrequency, true);
            int vegetableCount = calculateTotalProductCount(wordFrequency, false);
            System.out.println("Всего фруктов на пикнике: " + fruitCount);
            System.out.println("Всего овощей на пикнике: " + vegetableCount);

            // Популярные фрукты и овощи
            String popularFruit = findPopularProduct(wordFrequency, true);
            String popularVegetable = findPopularProduct(wordFrequency, false);
            System.out.println("Самый популярный фрукт: " + popularFruit);
            System.out.println("Самый популярный овощ: " + popularVegetable);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }

}