
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your class here

        // >> Create a list and add values to it
        // List<String> myList = new List<>();
        // myList.add("hello");
        // myList.add("world");

        // >> Inspect elements in a list
        // List<String> myList = new List<>();
        // System.out.println(myList.contains("hello"));
        // myList.add("hello");
        // System.out.println(myList.contains("hello"));

        // >> List can add, check contents, and remove
        // List<String> myList = new List<>();
        // System.out.println(myList.contains("hello"));
        // myList.add("hello");
        // System.out.println(myList.contains("hello"));
        // myList.remove("hello");
        // System.out.println(myList.contains("hello"));

        List<String> myList = new List<>();
        myList.add("hello");
        myList.add("world");

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.value(i));
        }
    }

}
