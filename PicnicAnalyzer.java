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

    private void printWordFrequency(Map<String, Integer> wordFrequency) {
        System.out.println("Частота слов:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private int calculateTotalProductCount(Map<String, Integer> wordFrequency, boolean isFruit) {
        int totalCount = 0;
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if ((isFruit && productCatalog.isFruit(word)) || (!isFruit && productCatalog.isVegetable(word))) {
                totalCount += count;
            }
        }
        return totalCount;
    }
    
    private String findPopularProduct(Map<String, Integer> wordFrequency, boolean isFruit) {
        int maxCount = 0;
        String popularProduct = "";
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if ((isFruit && productCatalog.isFruit(word)) || (!isFruit && productCatalog.isVegetable(word))) {
                if (count > maxCount) {
                    maxCount = count;
                    popularProduct = word;
                }
            }
        }
        return popularProduct;
    }

}
