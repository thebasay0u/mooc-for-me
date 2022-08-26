public class Pair<K, V> {
    private K _key;
    private V _value;

    public Pair(K key, V value) {
        this._key = key;
        this._value = value;
    }

    public K getKey() {
        return _key;
    }

    public V getValue() {
        return _value;
    }

    public void setValue(V value) {
        this._value = value;
    }

}
