package title;

import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserTitle extends Application {

    @Override
    public void start(Stage window) throws Exception {
        // TODO Auto-generated method stub
        // Parameters params = getParameters();
        // String org = params.getNamed().get("organization");
        // String course = params.getNamed().get("course");

        Scanner s = new Scanner(System.in);

        window.setTitle(getTitleFromUser(s));
        window.show();

    }

    private static String getTitleFromUser(Scanner scanner) {
        System.out.print("Please enter a title for the window:");
        String title = scanner.nextLine();
        return title;

    }

}
