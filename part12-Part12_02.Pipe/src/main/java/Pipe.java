import java.util.ArrayList;

public class Pipe<T> extends ArrayList {
    private ArrayList<T> _pipe;

    public Pipe() {
        this._pipe = new ArrayList<T>();
    }

    public void putIntoPipe(T value) {
        this._pipe.add(0, value);
    }

    public T takeFromPipe() {

        if (this._pipe.isEmpty())
            return null;

        int lastIndex = this._pipe.size() - 1;
        return this._pipe.remove(lastIndex);
    }

    public boolean isInPipe() {
        if (this._pipe.isEmpty())
            return false;
        else
            return true;
    }

}
