package com.dicegame.dicegame;

import GUI.Tablero;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Tablero tb = new Tablero();
        Scene scene = new Scene(tb, 720, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
