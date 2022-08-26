
import java.util.Scanner;

public class Program {

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        int lowerLimit = fromWhere;
        int upperLimit = toWhere;
        int sum = 0;
        if (lowerLimit < 0)
            lowerLimit = 0;
        if (upperLimit > array.length) {
            upperLimit = array.length;
        }

        for (int i = lowerLimit; i < upperLimit; i++) {
            int value = array[i];
            if (value >= smallest && value <= largest) {
                sum += value;

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here

        int[] numbers = { 3, -1, 8, 4 };

        System.out.println(sum(numbers, 0, 0, 0, 0));
        System.out.println(sum(numbers, 0, 0, 0, 10));
        System.out.println(sum(numbers, 0, 1, 0, 10));
        System.out.println(sum(numbers, 0, 1, -10, 10));
        System.out.println(sum(numbers, -1, 999, -10, 10));

    }

}
