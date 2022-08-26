import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> _cart;

    public ShoppingCart() {
        this._cart = new HashMap<>();

    }

    public void add(String product, int price) {
        // # adds an item to the cart that matches the product and price given as
        // # parameters
        if (!(this._cart.containsKey(product))) {
            this._cart.put(product, new Item(product, 1, price));
        } else {
            this._cart.get(product).increaseQuantity();
        }

    }

    public int price() {
        // # returns the total price of the shopping cart
        int totalPrice = 0;
        for (Item item : this._cart.values()) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public void print() {
        for (Item item : this._cart.values())
            System.out.println(item);
    }
}
