import java.util.Objects;

public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    // # Working
    // # Implemented to ignore weight
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Item)) {
            return false;
        }

        Item compItem = (Item) obj;
        return this.name.equals(compItem.name) ? true : false;
    }

    // # Working
    // # Implemented to ignore weight

    @Override
    public int hashCode() {

        int hash = 7;
        // hash += this.weight;
        for (int i = 0; i < this.name.length(); i++) {
            hash = hash * 31 + this.name.charAt(i);
        }
        return Objects.hash(hash, this.name);
    }

}
