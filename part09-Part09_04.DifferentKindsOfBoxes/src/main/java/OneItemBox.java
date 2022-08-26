import java.util.ArrayList;

public class OneItemBox extends Box {

    // private final int capacity = 1;
    private ArrayList<Item> uselessBox;

    public OneItemBox() {
        this.uselessBox = new ArrayList<>();

    }

    public void add(Item item) {
        if (this.uselessBox.isEmpty()) {
            uselessBox.add(item);
        } else {
            return;
        }

    }

    public boolean isInBox(Item item) {
        return this.uselessBox.contains(item) ? true : false;

    }

}
