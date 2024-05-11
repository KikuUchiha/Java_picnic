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
    }

    private void initializeVegetables() {
    }

}
