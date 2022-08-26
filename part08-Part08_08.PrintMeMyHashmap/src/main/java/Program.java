
import java.util.HashMap;

public class Program {

    public static String sanitizeString(String string) {
        if (string == null)
            return "";

        string = string.toLowerCase();
        return string.trim();

    }

    public static void printKeys(HashMap<String, String> hashmap) {
        // # PRINTS ALL THE KEYS IN THE HASHMAP GIVEN AS A PARAMETER
        for (String s : hashmap.keySet()) {
            System.out.println(s);
        }
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        // # PRINTS THE KEYS IN THE HASHMAP GIVEN AS A PARAMETER, WHICH CONTAIN THE
        // # GIVEN STRING AS A PARAMETER

        for (String key : hashmap.keySet()) {
            if (key.contains(text)) {
                System.out.println(key);
            }
        }

    }

    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {

        for (String key : hashmap.keySet()) {
            if (key.contains(text)) {
                System.out.println(hashmap.get(key));
            }
        }
    }

    public static void main(String[] args) {
        // Test your program here!

        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("f.e", "for example");
        hashmap.put("etc.", "and so on");
        hashmap.put("i.e", "more precisely");

        printKeys(hashmap);
        System.out.println("---");
        printKeysWhere(hashmap, "i");
        System.out.println("---");
        printValuesOfKeysWhere(hashmap, ".e");
    }

}
