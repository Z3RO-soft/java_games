module com.wasp.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.wasp.game to javafx.fxml;
    exports com.wasp.game;
}