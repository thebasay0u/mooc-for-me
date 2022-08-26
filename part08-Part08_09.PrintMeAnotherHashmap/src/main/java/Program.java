
import java.util.HashMap;

public class Program {

    public static void printValues(HashMap<String, Book> hashMap) {
        // # Prints all values in the hashmap given as a parameter using the toString
        // method of the Book objects

        for (Book book : hashMap.values()) {
            System.out.println(book);
        }
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
        // # Prints only the books in the hashmap that contain the given string

        for (Book book : hashmap.values()) {
            if (book.getName().contains(text)) {

                System.out.println(book);
            }
        }

    }

    public static void main(String[] args) {
        // Test your program here!

        HashMap<String, Book> hashmap = new HashMap<>();
        hashmap.put("sense", new Book("Sense and Sensibility", 1811, "..."));
        hashmap.put("prejudice", new Book("Pride and prejudice", 1813, "...."));

        printValues(hashmap);
        System.out.println("---");
        printValueIfNameContains(hashmap, "prejud");
    }

}
