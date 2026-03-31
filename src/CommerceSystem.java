import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    List<Product> products;

    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (true){
            // 상품 목록 출력
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for(int i = 0;  i< products.size(); i++){
                Product p = products.get(i);
                System.out.printf("%d. %-15s| %,9d원 | %s%n", i + 1, p.name, p.price, p.description, p.stock);
            }
            System.out.println("0. 종료          | 프로그램 종료");

            int inputNum = sc.nextInt();

            if(inputNum == 0){
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
        }
    }

}
