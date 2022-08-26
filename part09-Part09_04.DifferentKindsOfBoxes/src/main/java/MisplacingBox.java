import java.util.ArrayList;

public class MisplacingBox extends Box {
    private ArrayList<Item> _magicBox;

    public MisplacingBox() {
        this._magicBox = new ArrayList<>();

    }

    public void add(Item item) {
        this._magicBox.add(item);

    }

    @Override
    public boolean isInBox(Item item) {
        // TODO Auto-generated method stub
        return false;
    }

}
