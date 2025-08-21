package com.wasp.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button mainBtn;

    @FXML
    private Button secondBtn;

    @FXML
    private Label mainLabel;

    @FXML
    void btnClick1(ActionEvent event) {
        mainLabel.setText(mainBtn.getText());
    }

    @FXML
    void btnClick2(ActionEvent event) {
        mainLabel.setText(secondBtn.getText());
    }

    @FXML
    void initialize() {

    }

}
