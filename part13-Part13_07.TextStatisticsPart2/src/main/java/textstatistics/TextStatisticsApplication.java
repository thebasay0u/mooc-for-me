package textstatistics;

import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);

    }

    @Override
    public void start(Stage window) throws Exception {
        // # BorderPane to handle layout
        BorderPane layout = new BorderPane();

        // # create TextArea and add as top of layout
        TextArea notepad = new TextArea();
        layout.setCenter(notepad);

        // # Hbox to handle layout of statistics
        HBox horizontalBox = new HBox();
        horizontalBox.setSpacing(10);
        horizontalBox.getChildren().add(new Label("Letters: 0"));
        horizontalBox.getChildren().add(new Label("Words: 0"));
        horizontalBox.getChildren().add(new Label("The longest word is:"));

        // # set Hbox to bottom of layout
        layout.setBottom(horizontalBox);

        // todo: calculate statistics
        // $ numLetters
        // $ numWords
        // $ longestWord
        calculateStatistics(notepad, horizontalBox);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();

    }

    private void calculateStatistics(TextArea notepad, HBox hBox) {
        notepad.textProperty().addListener((change, oldValue, newValue) -> {
            // System.out.println(oldValue + " -> " + newValue);
            int numLetters = newValue.length();
            String[] parts = newValue.split(" ");
            int numWords = parts.length;
            String longestWord = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            hBox.getChildren().clear();
            hBox.getChildren().addAll(new Label("Letters: " + numLetters),
                    new Label("Words: " + numWords), new Label("The longest word is: " + longestWord));

        });

    }

}
