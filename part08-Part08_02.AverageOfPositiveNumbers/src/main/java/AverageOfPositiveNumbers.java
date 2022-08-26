
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPositives = 0;
        double sumPositives = 0;
        // boolean keepGoing = true;
        while (true) {
            double userInput = Double.parseDouble(scanner.nextLine());
            if (userInput == 0) {
                break;
            } else if (userInput > 0) {
                numPositives++;
                sumPositives += userInput;
            } else {
                continue;
            }
        }
        if (sumPositives <= 0) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(sumPositives / numPositives);
        }
    }
}
