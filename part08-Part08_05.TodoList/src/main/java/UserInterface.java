import java.util.Scanner;

public class UserInterface {

    private TodoList list;
    private Scanner scan;

    public UserInterface(TodoList todoList, Scanner scanner) {
        this.list = todoList;
        this.scan = scanner;
    }

    public void start() {
        final String addCommand = "add";
        final String listCommand = "list";
        final String removeCommand = "remove";
        final String stopCommand = "stop";
        // # command: stop --> ends loop, after which program moves beyond start()
        // method
        // # command: add --> asks the user for the next task to be added. Once the user
        // enters the task, it should be added to the todoList

        // # command: list --> prints all tasks on the todoList

        // # command: remove --> asks the user to enter the id of the task to be
        // removed. When this has been entered, the specified task should be removed
        // from the list of tasks.
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Command:");
            String userString = scan.nextLine();
            switch (userString) {
                case addCommand:
                    System.out.println("To add:");
                    String addMe = scan.nextLine();
                    list.add(addMe);
                    break;
                case listCommand:
                    list.print();
                    break;
                case removeCommand:
                    System.out.println("Which one is removed?");
                    int taskId = Integer.parseInt(scan.nextLine());
                    list.remove(taskId);
                    break;
                case stopCommand:
                    keepGoing = false;
                    break;

            }

        }
    }
}