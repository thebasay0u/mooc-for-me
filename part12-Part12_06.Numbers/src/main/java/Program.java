
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random rng = new Random();
        System.out.println("How many random numbers should be printed?");
        int numToPrint = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numToPrint; i++) {
            System.out.println(rng.nextInt(11));
        }
    }

}
