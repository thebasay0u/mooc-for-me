import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private int _maxWeight;
    private ArrayList<Item> _weightLimitedBox;

    public BoxWithMaxWeight(int capacity) {
        this._maxWeight = capacity;
        this._weightLimitedBox = new ArrayList<>();

    }

    @Override
    public void add(Item item) {
        // TODO Auto-generated method stub
        int currentWeight = this.getCurrentWeight();
        if (item.getWeight() > this._maxWeight)
            return;
        int remainingCapacity = this._maxWeight - currentWeight;
        if (item.getWeight() > remainingCapacity)
            return;

        this._weightLimitedBox.add(item);

    }

    public int getCurrentWeight() {
        int currentWeight = 0;
        for (Item item : _weightLimitedBox) {
            currentWeight += item.getWeight();
        }
        return currentWeight;
    }

    @Override
    public boolean isInBox(Item item) {
        // TODO Auto-generated method stub
        if (this._weightLimitedBox.contains(item))
            return true;
        else
            return false;
    }

}
