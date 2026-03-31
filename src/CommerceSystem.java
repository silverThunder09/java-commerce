import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    List<Category> categories;
    List<Customer> customers;

    public CommerceSystem(List<Category> categories, List<Customer> customers) {
        this.categories = categories;
        this.customers = customers;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            // 카테고리 목록 출력
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i < categories.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, categories.get(i).categoryName);
            }
            System.out.println("0. 종료      | 프로그램 종료");

            int inputNum = sc.nextInt();

            if (inputNum == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            } else if (inputNum >= 1 && inputNum <= categories.size()) {
                displayProducts(sc, categories.get(inputNum - 1));
            }
        }
        sc.close();
    }

    // 상품 목록 출력 하는 메서드
    public void displayProducts(Scanner sc, Category category) {
        while (true) {

            System.out.println("[ " + category.getCategoryName() + " 카테고리 ] ");
            List<Product> products = category.getProducts();

            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.printf("%d. %-15s | %,9d원 | %s%n", i + 1, p.name, p.price, p.description, p.stock);
            }
            System.out.println("0. 뒤로가기");

            int inputNum = sc.nextInt();

            if (inputNum == 0) {
                break;
            } else if (inputNum >= 1 && inputNum <= products.size()) {
                Product p = products.get(inputNum - 1);
                System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개%n",
                        p.name, p.price, p.description, p.stock);
                break;
            }
        }

    }
}
