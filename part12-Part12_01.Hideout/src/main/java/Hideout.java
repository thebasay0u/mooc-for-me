import java.util.ArrayList;
import java.util.List;

public class Hideout<T> extends ArrayList {
    ArrayList<T> _hideout;

    public Hideout() {
        this._hideout = new ArrayList<T>();

    }

    /**
     * * puts an object with a type in accordance with the type parameter given to
     * the class into the hideout
     * * In case an object is already in the hideout, it will disappear
     * 
     * @param toHide
     */
    public void putIntoHideout(T toHide) {
        if (this._hideout.contains(toHide)) {
            this._hideout.remove(toHide);
        } else {
            this._hideout.add(toHide);
        }

    }

    /**
     * * takes out the object with a type in accordance with the type parameter
     * * given to the the class from the hideout. In case there is nothing in the
     * * hideout, we return null. Calling the method returns the object in the
     * * hideout and removes the object from the hideout.
     * 
     * @return
     */
    public T takeFromHideout() {

        // TODO: implementation
        if (this._hideout.isEmpty())
            return null;

        return this._hideout.remove(0);

    }

    /**
     * * returns true if there is an object is in the hideout
     * * returns false if empty
     * 
     * @return
     */
    public boolean isInHideout() {
        if (this._hideout.isEmpty())
            return false;
        else
            return true;

    }
}
