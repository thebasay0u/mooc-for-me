
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                keepGoing = false;

            } else {
                int number = Integer.parseInt(input);
                System.out.println(number * number * number);
            }

        }
    }
}
