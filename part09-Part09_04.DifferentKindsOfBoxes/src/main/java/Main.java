
public class Main {

    public static void main(String[] args) {
        // You can test your program here

        // ! Test Part 1: Item class equals and hashcode
        // # Passed = true
        // Item testItem = new Item("test");
        // Item testItem2 = new Item("test");
        // Item testItem3 = new Item("Plug Play");
        // System.out.println(testItem.equals(testItem));

        // System.out.println(testItem.equals(testItem2));

        // System.out.println(testItem.equals(testItem3));

        // System.out.println("Hash code for item 1: " + testItem.hashCode());

        // System.out.println("Hash code for item 2: " + testItem2.hashCode());

        // System.out.println("Hash code for item 3: " + testItem3.hashCode());

        // ! Test Part 2: Weight limited box
        // # Passed = true

        // BoxWithMaxWeight coffeeBox = new BoxWithMaxWeight(10);
        // coffeeBox.add(new Item("Saludo", 5));
        // coffeeBox.add(new Item("Pirkka", 5));
        // coffeeBox.add(new Item("Kopi Luwak", 5));

        // System.out.println(coffeeBox.isInBox(new Item("Saludo")));
        // System.out.println(coffeeBox.isInBox(new Item("Pirkka")));
        // System.out.println(coffeeBox.isInBox(new Item("Kopi Luwak")));

        // ! Test Part 3: One item box

        OneItemBox box = new OneItemBox();
        box.add(new Item("Saludo", 5));
        box.add(new Item("Pirkka", 5));

        System.out.println(box.isInBox(new Item("Saludo")));
        System.out.println(box.isInBox(new Item("Pirkka")));

    }
}
