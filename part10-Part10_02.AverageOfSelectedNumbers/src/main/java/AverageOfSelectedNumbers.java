
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne

        ArrayList<String> inputs = new ArrayList<>();

        UserInterface ui = new UserInterface(scanner, inputs);
        ui.start();

    }
}
