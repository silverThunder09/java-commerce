import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 카테고리 목록
        Category electronics = new Category("전자제품");
        Category clothing = new Category("의류");
        Category food = new Category("식품");

        //  상품 목록
        electronics.addProduct(new Product("Galaxy S25",  1200000, "최신 안드로이드 스마트폰", 50));
        electronics.addProduct(new Product("iPhone 16",   1350000, "Apple의 최신 스마트폰",   50));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
        electronics.addProduct(new Product("AirPods Pro",  350000, "노이즈 캔슬링 무선 이어폰", 50));

        clothing.addProduct(new Product("루이비똥 셔츠1",1000000,"루이비똥 티셔츠1",5));
        clothing.addProduct(new Product("루이비똥 셔츠2",1500000,"루이비똥 티셔츠2",5));
        clothing.addProduct(new Product("루이비똥 셔츠3",20000010,"루이비똥 티셔츠3",5));
        clothing.addProduct(new Product("루이비똥 셔츠4",3000000,"루이비똥 티셔츠4",5));

        food.addProduct(new Product("사과",50000,"맛좋은 사과1",100));
        food.addProduct(new Product("포도",50000,"맛좋은 사과2",100));
        food.addProduct(new Product("키위",50000,"맛좋은 사과3",100));
        food.addProduct(new Product("바나나",50000,"맛좋은 사과4",100));

        List<Category> categories = new ArrayList<>();
        categories.add(electronics);
        categories.add(clothing);
        categories.add(food);

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("마요", "mayo@email.com", "VIP"));
        customers.add(new Customer("네즈", "nezz@email.com", "일반"));

        CommerceSystem commerceSystem = new CommerceSystem(categories,customers);
        commerceSystem.start();
    }
}
