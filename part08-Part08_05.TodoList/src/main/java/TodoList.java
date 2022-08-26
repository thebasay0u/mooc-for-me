import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<String>();

    }

    /**
     * * add the task passed as a parameter to the todo list.
     * 
     * @param task
     */
    public void add(String task) {
        tasks.add(task);

    }

    /**
     * * prints the exercises. Each task has a number associated with it on the
     * * print statement — use the task's index here (+1)
     * 
     */
    public void print() {
        for (String task : tasks) {
            System.out.println(String.format("%d: %s", tasks.indexOf((String) task) + 1, task));
        }

    }

    /**
     * * removes the task associated with the given number; the number is the one
     * * seen associated with the task in the print.
     * *
     * 
     * @param number
     */
    public void remove(int number) {
        tasks.remove(number - 1);

    }

}
