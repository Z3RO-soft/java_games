package com.wasp.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    private char nowSym = 'x';
    private char[][] gameField = new char[3][3];
    private boolean isGame = true;
    private int moveCount = 0;

    @FXML
    void btnClick(ActionEvent event) {
        if (!isGame) return;

        Button btn = (Button) event.getSource();
        if (!btn.getText().isEmpty()) return;

        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

        gameField[rowIndex][columnIndex] = nowSym;
        btn.setText(String.valueOf(nowSym));
        moveCount++;

        if (checkWin()) {
            showAlert("Перемога!", "Гравець '" + nowSym + "' виграв гру!");
            isGame = false;
            return;
        }

        if (moveCount == 9) {
            showAlert("Нічия!", "Усі клітинки заповнені. Гра закінчилася внічию!");
            isGame = false;
            return;
        }

        nowSym = (nowSym == 'x') ? 'o' : 'x';
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] != 0 && gameField[i][0] == gameField[i][1] && gameField[i][0] == gameField[i][2]) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (gameField[0][j] != 0 && gameField[0][j] == gameField[1][j] && gameField[0][j] == gameField[2][j]) {
                return true;
            }
        }

        if (gameField[0][0] != 0 && gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2]) {
            return true;
        }
        if (gameField[0][2] != 0 && gameField[0][2] == gameField[1][1] && gameField[0][2] == gameField[2][0]) {
            return true;
        }

        return false;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameField[i][j] = 0;
            }
        }
    }
}