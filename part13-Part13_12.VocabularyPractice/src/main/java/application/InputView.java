package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {

    private Dictionary _dictionary;

    public InputView(Dictionary dictionary) {
        this._dictionary = dictionary;
    }

    /**
     * * Uses Parent class (superclass of all layouts) to return a
     * * view for entering words and their translations into the dictionary with all
     * * components/formatting added
     * 
     * @return
     */
    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordLabel = new Label("Word");
        TextField wordField = new TextField();
        Label translationLabel = new Label("Translation");
        TextField translationField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addWordButton = new Button("Add the word pair");

        layout.add(wordLabel, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translationLabel, 0, 2);
        layout.add(translationField, 0, 3);
        layout.add(addWordButton, 0, 4);

        addWordButton.setOnMouseClicked((event) -> {
            String word = wordField.getText();
            String translation = translationField.getText();

            _dictionary.add(word, translation);

            wordField.clear();
            translationField.clear();
        });

        return layout;
    }

}
