package com.dicegame.dicegame;


import GUI.TableroView;
import GUI.WorkStationView;
import Logic.WorkStation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TableroView tb = new TableroView();
        Scene scene = new Scene(tb, 720, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
