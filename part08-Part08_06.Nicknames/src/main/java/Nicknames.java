
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap<String, String> nicknames = new HashMap<>();

        nicknames.put("Matthew", "Matt");
        nicknames.put("Michael", "Mike");
        nicknames.put("Arthur", "Artie");

        String mattNickname = nicknames.get("Matthew");
        System.out.println(mattNickname);
    }

}
