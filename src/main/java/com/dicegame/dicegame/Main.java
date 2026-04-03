package com.dicegame.dicegame;

import GUI.BoardView;
import GUI.BotonesView;
import GUI.GameView;
import GUI.StationView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StationView sv = new StationView();
        sv.setNumeroEstacion(1);

        BotonesView bv = new BotonesView();
        BoardView brv = new BoardView();

        GameView gv = new GameView();
        Controlador controlador = new Controlador(gv);
        Scene scene = new Scene(gv, 1080, 480);

        try {
            scene.getStylesheets().add(getClass().getResource("/GUI/estilos.css").toExternalForm());
        } catch (Exception e) {
            System.out.println("No se pudo cargar el CSS, revisa la ruta.");
        }

        primaryStage.setTitle("Prueba de BotonesView");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}