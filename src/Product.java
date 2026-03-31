import java.util.ArrayList;
import java.util.List;

public class Product {

    List<Product> products = new ArrayList<>();

    String name;
    int price;
    String description;
    int stock;

    public Product(String name, int price, String description, int stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }
}
