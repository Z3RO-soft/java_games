module com.wasp.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.wasp.game to javafx.fxml;
    exports com.wasp.game;
}