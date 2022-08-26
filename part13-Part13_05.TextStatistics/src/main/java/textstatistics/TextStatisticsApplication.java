package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        // TODO Auto-generated method stub
        BorderPane layout = new BorderPane();

        HBox horizontalBox = new HBox();
        horizontalBox.setSpacing(10);
        horizontalBox.getChildren().add(new Label("Letters: 0"));
        horizontalBox.getChildren().add(new Label("Words: 0"));
        horizontalBox.getChildren().add(new Label("The longest word is:"));

        layout.setBottom(horizontalBox);
        layout.setCenter(new TextArea(""));

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();

    }

}
