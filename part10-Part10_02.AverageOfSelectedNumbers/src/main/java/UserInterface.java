
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner _scanner;
    private ArrayList<String> _inputs;

    public UserInterface(Scanner scanner, ArrayList<String> inputs) {
        this._scanner = scanner;
        this._inputs = inputs;
    }

    public void start() {
        boolean keepGoing = true;
        System.out.println("Input numbers, type \"end\" to stop.");
        while (keepGoing) {
            String input = _scanner.nextLine();
            if (input.equals("end")) {
                keepGoing = false;
                break;
            } else {
                _inputs.add(input);
            }

        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String input = _scanner.nextLine();
        double average = 0;
        switch (input) {

            case "n":
                average = _inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(num -> num < 0).average()
                        .getAsDouble();
                System.out.println("average of the numbers: " + average);
                keepGoing = false;
                break;

            case "p":
                average = _inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(num -> num > 0).average()
                        .getAsDouble();
                System.out.println("average of the numbers: " + average);
                keepGoing = false;
                break;
        }
    }

}
