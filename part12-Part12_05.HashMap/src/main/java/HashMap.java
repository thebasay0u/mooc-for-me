
/**
 * $ A hash map contains an array of lists. Each value on the list is a pair
 * $ (described in the previous section) that contains a key and a value. A hash
 * $ map also knows the number of the values. Here we have at our disposal the
 * $ previously created class List.
 * 
 */
public class HashMap<K, V> {
    private List<Pair<K, V>>[] _values;
    private int _firstEmptyIndex;

    public HashMap() {
        this._values = new List[32];
        this._firstEmptyIndex = 0;
    }

    /**
     * 
     * $ 1. Calculate a hash value for the key
     * $ 2. Use hash value to determine the index of in the internal array
     * $ 3. If no list in calculated index, then no key,value pairs have been
     * $ stored, return null
     * 
     * 
     * @param key
     * @return
     */
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this._values.length);
        if (this._values[hashValue] == null) {
            return null;
        }

        List<Pair<K, V>> valuesAtIndex = this._values[hashValue];

        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.value(i).getKey().equals(key)) {
                return valuesAtIndex.value(i).getValue();
            }
        }
        return null;
    }

    public void add(K key, V value) {

        List<Pair<K, V>> valuesAtIndex = getListFromKey(key);

        int index = getIndexOfKey(valuesAtIndex, key);

        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this._firstEmptyIndex++;
        } else {
            valuesAtIndex.value(index).setValue(value);
        }
        if (1.0 * this._firstEmptyIndex / this._values.length > .75) {
            grow();

        }
    }

    private List<Pair<K, V>> getListFromKey(K key) {
        int hash = Math.abs(key.hashCode() % _values.length);
        if (_values[hash] == null) {
            _values[hash] = new List<>();
        }
        return _values[hash];
    }

    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.value(i).getKey().equals(key)) {
                return i;

            }
        }
        return -1;
    }

    private void copy(List<Pair<K, V>>[] newArray, int fromIdx) {
        for (int i = 0; i < this._values[fromIdx].size(); i++) {
            Pair<K, V> value = this._values[fromIdx].value(i);

            int hash = Math.abs(value.getKey().hashCode() % newArray.length);
            if (newArray[hash] == null) {
                newArray[hash] = new List<>();
            }
            newArray[hash].add(value);
        }
    }

    private void grow() {
        // # create a new array
        List<Pair<K, V>>[] newArray = new List[this._values.length * 2];
        // # copy the values of old array into new one
        for (int i = 0; i < this._values.length; i++) {
            copy(newArray, i);
        }
        // # replace old array with new
        this._values = newArray;
    }

    public V remove(K key) {
        List<Pair<K, V>> valuesAtIndex = getListFromKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }

        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }

        Pair<K, V> pair = valuesAtIndex.value(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }
}
