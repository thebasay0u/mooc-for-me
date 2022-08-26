
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean keepGoing = true;

        // # Containers start at 0 and max out at 100
        int firstContainer = 0, secondContainer = 0;

        while (keepGoing) {
            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");

            String input = scan.nextLine();

            if (input.equals("quit")) {
                keepGoing = false;
            }
            // # ADD COMMAND
            else {
                String[] splitInput = input.split(" ");
                String command = splitInput[0];
                int amount = Integer.parseInt(splitInput[1]);

                if (command.equals("add")) {
                    if (amount < 0) {
                        continue;
                    } else {
                        if (firstContainer + amount > 100) {
                            firstContainer = 100;
                        } else {
                            firstContainer += amount;

                        }
                    }
                } else if (command.equals("move")) {
                    if (amount < 0 || firstContainer == 0) {
                        continue;
                    } else {
                        if (firstContainer < amount) {
                            secondContainer = firstContainer;
                            firstContainer = 0;
                        } else {
                            firstContainer -= amount;
                            if (secondContainer + amount > 100)
                                secondContainer = 100;
                            else
                                secondContainer += amount;
                        }

                    }

                } else if (command.equals("remove")) {
                    if (amount < 0) {
                        continue;
                    } else {
                    }
                    if (secondContainer - amount < 0) {
                        secondContainer = 0;
                    } else {
                        secondContainer -= amount;
                    }
                } else {
                    System.out.println("Invalid entry");
                    continue;
                }

            }
        }

    }
}
