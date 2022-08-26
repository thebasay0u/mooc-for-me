package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // # View 1 - text field asking for a user's name
        // # components: Label, TextField, and Start button

        BorderPane firstViewLayout = new BorderPane();
        firstViewLayout.setPadding(new Insets(50, 50, 50, 50));

        VBox firstViewComponents = new VBox(5);
        Label instructions = new Label("Enter your name and start.");
        TextField inputBox = new TextField();
        Button startButton = new Button("Start");
        firstViewComponents.getChildren().addAll(instructions, inputBox, startButton);
        firstViewLayout.setCenter(firstViewComponents);

        // # View 2 - Greeting text
        // # components: Label ("Welcome, USER_NAME")

        BorderPane secondViewLayout = new BorderPane();
        Label greeting = new Label("Welcome");
        secondViewLayout.setCenter(greeting);
        secondViewLayout.setPadding(new Insets(50, 50, 50, 50));

        // # Create scenes
        Scene firstScene = new Scene(firstViewLayout);
        Scene secondScene = new Scene(secondViewLayout);

        // # Add event handler logic to button
        startButton.setOnAction((event) -> {
            greeting.setText("Welcome " + inputBox.getText().trim() + "!");
            primaryStage.setScene(secondScene);

        });

        primaryStage.setScene(firstScene);
        primaryStage.show();

    }
}
