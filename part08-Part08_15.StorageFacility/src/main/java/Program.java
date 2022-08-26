
public class Program {

    public static void main(String[] args) {
        // Test your program here
        // StorageFacility facility = new StorageFacility();
        // facility.add("a14", "ice skates");
        // facility.add("a14", "ice hockey stick");
        // facility.add("a14", "ice skates");

        // facility.add("f156", "rollerblades");
        // facility.add("f156", "rollerblades");

        // facility.add("g63", "six");
        // facility.add("g63", "pi");

        // // facility.remove("f156", "rollerblades");
        // System.out.println(facility.);

        // System.out.println(facility.contents("f156"));
        // System.out.println(facility.storageUnits());

        // StorageUnit unit = new StorageUnit("Matt's unit");

        // unit.addItem("Computer");
        // unit.addItem("Headphones");
        // unit.addItem("Xbox");

        // System.out.println(unit);

        // unit.removeItemFromUnit("Xbox");

        // System.out.println(unit);
        // System.out.println(unit.equals(unit));

        // StorageUnit unit2 = new StorageUnit("Matt's unit");
        // unit2.addItem("Computer");
        // unit2.addItem("Headphones");

        // System.out.println(unit.equals(unit2));
        // ! Hash codes are the same, so the units are equal when name + contents are
        // ! equal
        // System.out.println("Hash of unit 1: " + unit.hashCode());

        // System.out.println("Hash of unit 2: " + unit2.hashCode());

        // ! TESTING PART 1: Adding items and examining contents
        // StorageFacility facility = new StorageFacility();
        // facility.add("a14", "ice skates");
        // facility.add("a14", "ice hockey stick");
        // facility.add("a14", "ice skates");

        // facility.add("f156", "rollerblades");
        // facility.add("f156", "rollerblades");

        // facility.add("g63", "six");
        // facility.add("g63", "pi");

        // System.out.println(facility.contents("a14"));
        // System.out.println(facility.contents("f156"));

        // ! TESTING PART 2: Listing the units and removing from unit

        StorageFacility facility = new StorageFacility();
        facility.add("a14", "ice skates");
        facility.add("a14", "ice hockey stick");
        facility.add("a14", "ice skates");

        facility.add("f156", "rollerblades");
        facility.add("f156", "rollerblades");

        facility.add("g63", "six");
        facility.add("g63", "pi");

        facility.remove("f156", "rollerblades");

        System.out.println(facility.contents("f156"));

        facility.remove("f156", "rollerblades");

        System.out.println(facility.storageUnits());
    }
}
