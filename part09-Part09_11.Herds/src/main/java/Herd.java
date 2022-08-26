import java.util.ArrayList;

public class Herd implements Movable {

    private ArrayList<Movable> _herd;

    public Herd() {
        this._herd = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this._herd.add(movable);

    }

    @Override
    public void move(int dx, int dy) {
        for (Movable m : this._herd) {
            m.move(dx, dy);

        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable m : this._herd) {
            sb.append(m + "\n");
        }
        return sb.toString();
    }

}
