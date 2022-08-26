import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> _productPrices;
    private Map<String, Integer> _productLevels;

    public Warehouse() {
        this._productPrices = new HashMap<>();
        this._productLevels = new HashMap<>();

    }

    public void addProduct(String product, int price, int stock) {
        // todo: implementation

        this._productPrices.put(product, price);
        this._productLevels.put(product, stock);

    }

    public int price(String product) {

        if (this._productPrices.keySet().contains(product))
            return this._productPrices.get(product);
        else
            return -99;
    }

    public int stock(String product) {
        // todo: returns the current remaining stock of the product in the warehouse. If
        // # the product hasn't been added to the warehouse, the method must return 0.
        if (this._productLevels.containsKey(product))
            return this._productLevels.get(product);
        else
            return 0;

    }

    public boolean take(String product) {
        // todo: reduces the stock remaining for the product it received as a parameter
        // # by one, and returns true if there was stock remaining. If the product was
        // not
        // # available in the warehouse the method returns false. A products stock can't
        // # go below zero.
        if (this._productLevels.containsKey(product)) {
            int currentLevel = this._productLevels.get(product);
            if (currentLevel > 0) {
                currentLevel--;
                this._productLevels.put(product, currentLevel);
                return true;

            }
        }

        return false;

    }

    public Set<String> products() {
        return this._productPrices.keySet();
    }

}
