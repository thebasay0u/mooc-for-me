package ticTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private TileBoard _tileBoard;
    private Label message;

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        try {

            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, UIConstants.APP_WIDTH, UIConstants.APP_HEIGHT);

            message = new Label("Turn: X");
            message.setFont(Font.font("Monospaced", 40));

            this._tileBoard = new TileBoard(message);

            root.setCenter(_tileBoard.getGridPane());
            root.setTop(message);

            window.setScene(scene);
            window.setResizable(false);
            window.show();
            // _tileBoard.checkForWinner();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public String getMessage() {
        return message.getText();
    }

}
