module com.dicegame.dicegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dicegame.dicegame to javafx.fxml;
    exports com.dicegame.dicegame;
}