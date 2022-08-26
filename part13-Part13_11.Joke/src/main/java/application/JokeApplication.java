package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {

        BorderPane layout = new BorderPane();
        layout.setPrefSize(300, 150);

        // # HBox as a menu of buttons
        HBox menu = new HBox();

        // # Create buttons
        Button joke = new Button("Joke");
        Button punchline = new Button("Answer");
        Button explanation = new Button("Explanation");
        menu.getChildren().addAll(joke, punchline, explanation);
        menu.setSpacing(20);
        menu.setAlignment(Pos.BASELINE_CENTER);
        menu.setPadding(new Insets(5, 5, 5, 5));

        // # Set HBox to bottom of layout
        layout.setBottom(menu);

        // # Add sublayouts for punchline and explanation
        StackPane jokeLayout = createLayout("What do you call a bear with no teeth?");
        layout.setCenter(jokeLayout);
        StackPane punchlineLayout = createLayout("A gummy bear.");

        StackPane explanationLayout = createLayout("Since a bear without teeth only has gums, it's a 'gummy' bear!");
        Node tempNode = explanationLayout.getChildren().get(0);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
        // # Logic for buttons using helper method
        changeScenes(layout, joke, jokeLayout);
        changeScenes(layout, explanation, explanationLayout);
        changeScenes(layout, punchline, punchlineLayout);

    }

    public StackPane createLayout(String labelContents) {

        StackPane layout = new StackPane();
        layout.setPrefSize(400, 200);
        layout.setPadding(new Insets(10, 5, 10, 5));
        Label contents = new Label(labelContents);
        layout.getChildren().add(contents);
        layout.setAlignment(Pos.CENTER);
        return layout;

    }

    public static void changeScenes(BorderPane layout, Button button, StackPane content) {
        button.setOnAction((event) -> {
            layout.setCenter(content);

        });
    }

}
