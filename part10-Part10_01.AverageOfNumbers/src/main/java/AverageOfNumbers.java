
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here

        ArrayList<String> inputs = new ArrayList<>();

        UserInterface ui = new UserInterface(scanner, inputs);
        ui.start();

        double average = inputs.stream().mapToInt(s -> Integer.valueOf(s)).average().getAsDouble();

        System.out.println("average of the numbers: " + average);

    }
}
