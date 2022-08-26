package ticTacToe;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class TileBoard {

    private GridPane pane;
    private char playerTurn = 'X';
    private char[][] playerMoves;

    private boolean gameOver = false;
    private int turnNumber;
    private String _winner;
    private Label _instructionMessage;

    public TileBoard(Label instructionMessage) {
        this._instructionMessage = instructionMessage;
        pane = new GridPane();
        addButtonsToGridPane();
        pane.setMinSize(UIConstants.APP_WIDTH, UIConstants.TILE_BOARD_HEIGHT);

        pane.setAlignment(Pos.CENTER);

        this.playerMoves = new char[3][3];
        this.turnNumber = 1;
        this._winner = "";

    }

    private void addButtonsToGridPane() {
        int numToCreate = 9;
        while (numToCreate > 0)
            for (int row = 0; row < 3; row++) {

                for (int col = 0; col < 3; col++) {

                    pane.add(createButton(), col, row);

                    numToCreate--;

                }
            }
    }

    public GridPane getGridPane() {
        return pane;
    }

    // # working
    public void changePlayerTurn() {
        // System.out.println("Turn number before fn call = " + turnNumber);
        checkForWinner();
        if (!gameOver) {
            if (playerTurn == 'X') {
                playerTurn = 'O';
            } else {
                playerTurn = 'X';
            }
            this._instructionMessage.setText("Turn: " + playerTurn);
            turnNumber++;
        } else {
            return;
        }

    }

    // # working
    public void endGame(String winner) {

        this.gameOver = true;
        this._instructionMessage.setText("The end!");
        this.disableTileBoard();

    }

    public void checkForWinner() {
        // Todo

        checkRowsForWinner();
        checkColumnsForWinner();
        checkDiagonals();

        checkForStalemate();

    }

    private void checkDiagonals() {

        checkPrimaryDiagonal();
        checkSecondaryDiagonal();
    }

    private void checkSecondaryDiagonal() {
        if (!gameOver) {

            if (playerMoves[0][2] == playerMoves[1][1]
                    && playerMoves[0][2] == playerMoves[2][0]
                    && playerMoves[0][2] != 0) {
                String winner = String.valueOf(playerMoves[0][2]);
                endGame(winner);
                System.out.println("Winner is " + winner + " by secondary diagonal (top-right to bottom-left)");
            }
        }

    }

    private void checkPrimaryDiagonal() {
        if (!gameOver) {

            if (playerMoves[0][0] == playerMoves[1][1]
                    && playerMoves[0][0] == playerMoves[2][2]
                    && playerMoves[0][0] != 0) {
                String winner = String.valueOf(playerMoves[0][0]);
                endGame(winner);
                System.out.println("Winner is " + winner + " by primary diagonal (top-left to bottom-right)");
            }
        }
    }

    public void disableTileBoard() {
        pane.setDisable(true);
    }

    public void enableTileBoard() {
        pane.setDisable(false);
    }

    // # WORKING
    private void checkForStalemate() {
        if (turnNumber <= 8)
            return;

        if (!gameOver) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (playerMoves[row][col] == 0) {
                        return;
                    }
                }
            }
            gameOver = true;

        }
        System.out.println("Stalemate bro...");
        this._instructionMessage.setText("Stalemate bro...");

    }

    // # WORKING
    private void checkRowsForWinner() {
        for (int row = 0; row < 3; row++) {
            if (playerMoves[row][0] == playerMoves[row][1] &&
                    playerMoves[row][0] == playerMoves[row][2] && playerMoves[row][0] != 0
                    && playerMoves[row][1] == playerMoves[row][2]) {
                String winner = String.valueOf(playerMoves[row][0]);
                this._winner = winner;
                endGame(winner);
                System.out.println("Winner is " + winner + " by rows");

                return;

            }

        }

    }

    // # WORKING
    private void checkColumnsForWinner() {

        for (int col = 0; col < 3; col++) {
            if (playerMoves[0][col] == playerMoves[1][col]
                    && playerMoves[0][col] == playerMoves[2][col] && playerMoves[1][col] == playerMoves[2][col] &&
                    playerMoves[0][col] != 0) {

                String winner = String.valueOf(playerTurn);
                this._winner = winner;
                endGame(winner);
                System.out.println("Winner is " + winner + " by columns");

                return;

            }
        }

    }

    private String getWinner() {
        return this._winner;
    }

    public String getPlayerTurn() {
        return String.valueOf(playerTurn);
    }

    public int getTurnNumber() {
        return this.turnNumber;
    }

    public Button createButton() {
        Button btn = new Button();
        btn.setMinSize(80, 80);
        btn.setFont(Font.font("Monospaced", 40));

        btn.setOnMouseClicked(event -> {

            String tileMessage = String.valueOf(playerTurn);
            btn.setText(tileMessage);
            btn.setAlignment(Pos.CENTER);

            int col = GridPane.getColumnIndex(btn);
            int row = GridPane.getRowIndex(btn);

            playerMoves[row][col] = playerTurn;

            btn.setDisable(true);
            changePlayerTurn();

        });

        return btn;
    }

}
