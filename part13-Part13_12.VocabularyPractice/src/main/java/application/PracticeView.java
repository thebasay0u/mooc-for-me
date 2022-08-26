package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {

    private Dictionary _dictionary;
    private String _word;

    public PracticeView(Dictionary dictionary) {

        this._dictionary = dictionary;
        this._word = dictionary.getRandomWord();

    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordDirections = new Label("Translate the word '" + this._word + "'");
        TextField translationField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button checkWordButton = new Button("Check");

        Label feedback = new Label("");

        layout.add(wordDirections, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkWordButton, 0, 2);
        layout.add(feedback, 0, 3);

        checkWordButton.setOnMouseClicked((event) -> {
            String translation = translationField.getText();
            if (_dictionary.get(_word).equals(translation)) {
                feedback.setText(translation);
            } else {
                feedback.setText(
                        "Incorrect! The translation for the word '" + _word + "' is '" + _dictionary.get(_word) + "'.");
                return;
            }
            this._word = this._dictionary.getRandomWord();
            wordDirections.setText("Translate the word '" + this._word + "'");
            translationField.clear();
        });
        return layout;
    }
}
