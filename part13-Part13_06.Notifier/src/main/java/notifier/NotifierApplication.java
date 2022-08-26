package notifier;

import java.beans.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox components = new VBox(1);

        TextField top = new TextField();
        Label copiedText = new Label();

        Button copyButton = new Button("Copy");
        copyButton.setOnAction((event) -> {
            copiedText.setText(top.getText());
        });

        components.getChildren().addAll(top, copyButton, copiedText);

        Scene view = new Scene(components);

        primaryStage.setScene(view);
        primaryStage.show();

    }

}
