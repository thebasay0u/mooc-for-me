import java.util.ArrayList;

public class Box implements Packable {
    private double _maxCapacity;
    private ArrayList<Packable> _contents;

    public Box(double maximumCapacity) {
        this._maxCapacity = maximumCapacity;
        this._contents = new ArrayList<>();
    }

    public void add(Packable packableItem) {
        if (packableItem.weight() > this._maxCapacity)
            return;
        double remainingCapacity = this._maxCapacity - this.weight();
        if (packableItem.weight() > remainingCapacity)
            return;
        else {
            this._contents.add(packableItem);
        }

    }

    public double weight() {
        double weight = 0;
        for (Packable p : _contents) {
            weight += p.weight();
        }
        return weight;
    }

    private int getTotalItems() {
        return this._contents.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Box: ");
        sb.append(this.getTotalItems() + " items, total weight " + this.weight() + " kg");
        return sb.toString();
    }
}
