import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Boolean> fruits;
    private Map<String, Boolean> vegetables;

    public ProductCatalog() {
        fruits = new HashMap<>();
        vegetables = new HashMap<>();
        initializeFruits();
        initializeVegetables();
    }

    private void initializeFruits() {
        fruits.put("apple", true);
        fruits.put("banana", true);
        fruits.put("orange", true);
        fruits.put("pear", true);
        fruits.put("lemon", true);
        fruits.put("pineapple", true);
        fruits.put("kiwi", true);
    }

    private void initializeVegetables() {
        vegetables.put("carrot", true);
        vegetables.put("broccoli", true);
        vegetables.put("tomato", true);
        vegetables.put("cucumber", true);
        vegetables.put("carrot", true);
        vegetables.put("pepper", true);
        vegetables.put("onion", true);
    }

    public boolean isFruit(String product) {
        return fruits.containsKey(product.toLowerCase());
    }

    public boolean isVegetable(String product) {
        return vegetables.containsKey(product.toLowerCase());
    }
}
