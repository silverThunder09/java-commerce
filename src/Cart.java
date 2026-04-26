import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {

    private List<CartItem> cartItemList = new ArrayList<>();

    public void addItem(Product product, int quantity) {

        for(CartItem item : cartItemList) {
            if(item.getProduct().getName().equals(product.getName())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItemList.add(new CartItem(product,quantity));
    }

    public List<CartItem> getCartItemList() {
        return Collections.unmodifiableList(cartItemList);
    }

    public int calculateTotalPrice() {
        int total = 0;
        for(CartItem cartItem : cartItemList) {
            total += cartItem.getTotalPrice();
        }
        return  total;
    }

    // 비어있는지 확인
    public boolean isEmpty() {
        return cartItemList.isEmpty();
    }

    // 장바구니 비우기
    public void cartClear() {
        cartItemList.clear();
    }


}
