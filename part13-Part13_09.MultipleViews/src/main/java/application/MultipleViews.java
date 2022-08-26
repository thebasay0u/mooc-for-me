package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // # First view - BorderPane
        BorderPane bp = new BorderPane();
        bp.setTop(new Label("First view!"));
        Button firstToSecondView = new Button("To the second view!");
        bp.setCenter(firstToSecondView);
        Scene firstScene = new Scene(bp);

        // # Second view - VBox
        VBox vBox = new VBox();
        Button secondToThirdView = new Button("To the third view!");
        vBox.getChildren().add(secondToThirdView);
        vBox.getChildren().add(new Label("Second view!"));
        Scene secondScene = new Scene(vBox);

        // # Third view - GridPane
        GridPane gridLayout = new GridPane();
        gridLayout.add(new Label("Third view!"), 0, 0);
        Button thirdToFirstView = new Button("To the first view!");
        gridLayout.add(thirdToFirstView, 1, 1);
        Scene thirdScene = new Scene(gridLayout);

        // # Event handlers
        firstToSecondView.setOnAction((event) -> {
            primaryStage.setScene(secondScene);
        });
        secondToThirdView.setOnAction((event) -> {
            primaryStage.setScene(thirdScene);
        });
        thirdToFirstView.setOnAction((event) -> {
            primaryStage.setScene(firstScene);
        });

        primaryStage.setScene(firstScene);
        primaryStage.show();

    }

}
