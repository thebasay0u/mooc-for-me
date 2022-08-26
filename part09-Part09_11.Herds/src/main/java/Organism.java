public class Organism implements Movable {
    private int _x;
    private int _y;

    public Organism(int x, int y) {
        this._x = x;
        this._y = y;

    }

    @Override
    public void move(int dx, int dy) {

        this._x += dx;
        this._y += dy;

    }

    @Override
    public String toString() {
        String orgString = new String(String.format("x: %d; y: %d", this._x, this._y));
        return orgString;

    }

}
