module com.dicegame.dicegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.dicegame.dicegame to javafx.fxml;
    exports com.dicegame.dicegame;
}