import java.util.ArrayList;
import java.util.Objects;

public class StorageUnit {
    private String name;
    private ArrayList<String> contents;

    public StorageUnit(String unitName, ArrayList<String> contents) {
        this.name = unitName;
        this.contents = contents;
    }

    public StorageUnit(String unitName) {
        this.name = unitName;
        this.contents = new ArrayList<>();
    }

    // # WORKING = TRUE
    public String getUnitName() {
        return this.name;
    }

    // //# WORKING = TRUE
    public ArrayList<String> getUnitContents() {
        return this.contents;
    }

    // # WORKING = TRUE
    public void removeItemFromUnit(String item) {
        this.contents.remove(item);
    }

    // # WORKING = TRUE
    public void addItem(String item) {
        this.contents.add(item);
    }

    // # WORKING = TRUE
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof StorageUnit)) {
            return false;
        }

        StorageUnit compUnit = (StorageUnit) obj;

        return this.name.equals(compUnit.name) && this.contents.equals(compUnit.contents);
    }

    // # WORKING = TRUE
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        String hashMe = "hash me good baby";
        hashMe.concat(this.name);
        return Objects.hash(hashMe, this.name, this.contents);
    }

    public void printContents() {
        int counter = 1;
        for (String item : this.contents) {
            System.out.println("Item " + counter + ": " + item);
            counter++;
        }
    }

    // # WORKING = TRUE
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Unit name: " + this.name + "\n");
        sb.append("\n");

        int counter = 1;
        for (String item : this.contents) {
            sb.append("Item " + counter + ": " + item);
            sb.append("\n");
            counter++;
        }
        return sb.toString();
    }

}
