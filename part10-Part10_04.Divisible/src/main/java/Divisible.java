
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Divisible {

    public static void main(String[] args) {
        // ArrayList<Integer> numbers = new ArrayList<>();
        // numbers.add(3);
        // numbers.add(2);
        // numbers.add(-17);
        // numbers.add(-5);
        // numbers.add(7);

        // ArrayList<Integer> divisible = divisible(numbers);

        // divisible.stream()
        // .forEach(luku -> System.out.println(luku));
        List<Integer> values = new ArrayList<Integer>();
        values.add(3);
        values.add(2);
        values.add(-17);
        values.add(-6);
        values.add(8);

        ArrayList<Integer> positives = values.stream()
                .filter(value -> value > 0)
                .collect(Collectors.toCollection(ArrayList::new));

        positives.stream()
                .forEach(value -> System.out.println(value));
    }

    /**
     * * gathers numbers divisible by 2, 3, or 5 and returns them to a new list
     * 
     * @param numbers
     * @return
     */
    public static ArrayList<Integer> divisible(ArrayList<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 0 || x % 3 == 0 || x % 5 == 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
