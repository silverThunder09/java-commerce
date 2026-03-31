import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        //  상품 목록
        products.add(new Product("Galaxy S25",  1200000, "최신 안드로이드 스마트폰", 50));
        products.add(new Product("iPhone 16",   1350000, "Apple의 최신 스마트폰",   50));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
        products.add(new Product("AirPods Pro",  350000, "노이즈 캔슬링 무선 이어폰", 50));


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
        sc.close();
    }
}
