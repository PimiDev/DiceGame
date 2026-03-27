module com.dicegame.dicegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports com.dicegame.dicegame;

    opens GUI to javafx.graphics, javafx.fxml;
    exports GUI;
    opens com.dicegame.dicegame to javafx.fxml, javafx.graphics;

}