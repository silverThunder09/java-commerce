import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Category> categories;
    private List<Customer> customers;
    private Cart cart = new Cart();

    public CommerceSystem(List<Category> categories, List<Customer> customers) {
        this.categories = categories;
        this.customers = customers;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            displayMain();

            try {
                int inputNum = getMenuInput(sc, 0, 5);

                if ((inputNum == 4 || inputNum == 5) && cart.isEmpty()) {
                    throw new RuntimeException("장바구니가 비어있습니다. 상품을 먼저 담아 주세요.");
                }

                if (inputNum == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                } else if (inputNum >= 1 && inputNum <= categories.size()) {
                    displayProducts(sc, categories.get(inputNum - 1));
                } else if (inputNum == 4) {
                    // 장바구니 확인 기능
                } else if (inputNum == 5) {
                    // 주문하기 기능
                }

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }

    // 메인 메뉴 출력
    public void displayMain() {
        System.out.println("\n 아래 메뉴를 선택해주세요.");
        System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, categories.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 프로그램 종료");

        if (!cart.isEmpty()) {
            System.out.println("[  주문 관리 ]");
            System.out.println("4. 장바구니 확인      | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. 주문 취소         | 진행중인 주문을 취소합니다.");
        }
    }

    private void displayProducts(Scanner sc, Category category) {
        while (true) {

            System.out.println("[ " + category.getCategoryName() + " 카테고리 ] ");
            List<Product> products = category.getProducts();

            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.printf("%d. %-15s | %,9d원 | %s%n", i + 1, p.getName(), p.getPrice(), p.getDescription());
            }
            System.out.println("0. 뒤로가기");

            int inputNum = getMenuInput(sc, 0, products.size());

            if (inputNum == 0) {
                break;
            }

            Product p = products.get(inputNum - 1);
            System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개%n", p.getName(), p.getPrice(), p.getDescription(), p.getStock());
            System.out.printf("\"%s | %,d원 | %s\"%n", p.getName(), p.getPrice(), p.getDescription());
            System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");

            int choice = getMenuInput(sc, 1, 2);

            if (choice == 1) {

                if (p.getStock() <= 0) {
                    System.out.println("재고가 없어 장바구니에 담을 수 없습니다.");
                } else {
                    cart.addItem(p, 1);
                    System.out.printf("%s가 장바구니에 추가되었습니다.%n", p.getName());
                }
            } else {
                System.out.println("취소되었습니다.");
            }
            break;
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
