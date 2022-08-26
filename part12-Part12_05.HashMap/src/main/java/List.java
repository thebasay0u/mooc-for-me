public class List<AnyType> {
    private AnyType[] _values;
    private int firstEmptyIndex;

    public List() {
        this._values = (AnyType[]) new Object[10];
        this.firstEmptyIndex = 0;
    }

    public void add(AnyType value) {
        if (this.firstEmptyIndex == this._values.length) {
            grow();

        }
        this._values[this.firstEmptyIndex] = value;
        this.firstEmptyIndex++;
    }

    private void grow() {
        int growThisMuch = this._values.length + this._values.length / 2;
        AnyType[] biggerArray = (AnyType[]) new Object[growThisMuch];
        for (int i = 0; i < this._values.length; i++) {
            biggerArray[i] = this._values[i];

        }
        this._values = biggerArray;
    }

    public boolean contains(AnyType value) {
        return indexOfValue(value) >= 0;
    }

    public int indexOfValue(AnyType value) {
        for (int i = 0; i < this.firstEmptyIndex; i++) {
            if (this._values[i].equals(value)) {
                return i;
            }
        }
        return -1;

    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstEmptyIndex - 1; i++) {
            this._values[i] = this._values[i + 1];
        }

    }

    public void remove(AnyType value) {
        int indexOfValue = indexOfValue(value);
        if (indexOfValue < 0) {
            return;
        }

        moveToTheLeft(indexOfValue);
        this.firstEmptyIndex--;
    }

    public AnyType value(int index) {
        if (index < 0 || index >= this.firstEmptyIndex) {
            throw new ArrayIndexOutOfBoundsException(
                    "Index " + index + " outside of [0, " + this.firstEmptyIndex + "]");
        }
        return this._values[index];
    }

    public int size() {
        return this.firstEmptyIndex;
    }

}
