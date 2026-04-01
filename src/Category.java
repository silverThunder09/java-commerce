import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Category {

    private String categoryName;
    private List<Product> products;

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
