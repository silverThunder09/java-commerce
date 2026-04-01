import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Category> categories;
    private List<Customer> customers;

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
                System.out.printf("%d. %s%n", i + 1, categories.get(i).getCategoryName());
            }
            System.out.println("0. 종료      | 프로그램 종료");

            int inputNum = getMenuInput(sc, 0, categories.size());

            if (inputNum == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            } else if (inputNum >= 1 && inputNum <= categories.size()) {
                displayProducts(sc, categories.get(inputNum - 1));
            }
        }
        sc.close();
    }

    // 카테고리 내 상품 목록 출력
    private void displayProducts(Scanner sc , Category category) {
        while (true) {

            System.out.println("[ " + category.getCategoryName() + " 카테고리 ] ");
            List<Product> products = category.getProducts();

            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.printf("%d. %-15s | %,9d원 | %s%n", i + 1, p.getName(), p.getPrice(), p.getDescription());
            }
            System.out.println("0. 뒤로가기");

            int inputNum = getMenuInput(sc, 0, categories.size());

            if (inputNum == 0) {
                break;
            } else if (inputNum >= 1 && inputNum <= products.size()) {
                Product p = products.get(inputNum - 1);
                System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개%n",
                        p.getName(), p.getPrice(), p.getDescription(), p.getStock());
                break;
            }
        }
    }

    private int getMenuInput(Scanner sc, int min, int max) {
        while (true) {
            try {
                int input = sc.nextInt();

                if (input < min || input > max) {
                    System.out.printf("%d ~ %d 사이의 숫자를 입력해주세요.%n", min, max);
                    continue;
                }

                return input;

            } catch (Exception e) {
                System.out.println("잘못된 입력입니다 다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}
