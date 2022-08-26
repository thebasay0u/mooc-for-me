public class Item {
    private String _productName;
    private int _quantity;
    private int _unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this._productName = product;
        this._quantity = qty;
        this._unitPrice = unitPrice;
    }

    public int price() {
        return this._unitPrice * this._quantity;
    }

    public void increaseQuantity() {
        this._quantity++;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(String.format("%s: %d", this._productName, this._quantity));
        return sb.toString();

    }
}
