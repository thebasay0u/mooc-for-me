import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private Container container1, container2;

    public UserInterface(Scanner scanner, Container container1, Container container2) {
        this.container1 = container1;
        this.container2 = container2;
        this.scan = scanner;

    }

    public void start() throws NumberFormatException {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("First: " + container1.toString());
            System.out.println("Second: " + container2.toString());
            String userInput = scan.nextLine();
            if (userInput.equals("quit")) {
                keepGoing = false;
                break;
            } else {
                String[] parts = userInput.split(" ");
                String command = parts[0];
                int amount = Integer.parseInt(parts[1]);
                switch (command) {
                    case "add":
                        container1.add(amount);
                        break;

                    case "move":
                        if (container1.contains() < amount) {
                            container2.add(container1.contains());
                            container1.setAmount(0);
                            break;

                        } else {
                            container1.remove(amount);
                            container2.add(amount);
                            break;
                        }

                    case "remove":
                        container2.remove(amount);
                        break;

                }

            }

        }
    }
}