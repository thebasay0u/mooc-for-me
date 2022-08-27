package smiley;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane layout = new BorderPane();

        Canvas smileyCanvas = new Canvas(600, 400);

        GraphicsContext painter = smileyCanvas.getGraphicsContext2D();

        painter.fillRect(150, 50, 50, 50);
        painter.fillRect(375, 50, 50, 50);
        painter.fillRect(100, 200, 50, 50);
        painter.fillRect(425, 200, 50, 50);
        painter.fillRect(140, 250, 300, 50);

        layout.setCenter(smileyCanvas);

        smileyCanvas.setOnMouseDragged((event) -> {
            double xLocation = event.getX();
            double yLocation = event.getY();
            painter.setFill(Paint.valueOf("Black"));
            painter.fillOval(xLocation, yLocation, 4, 4);
        });

        Scene view = new Scene(layout);

        primaryStage.setScene(view);
        primaryStage.show();

    }

}
