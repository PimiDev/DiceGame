package com.dicegame.dicegame;

import GUI.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Instanciamos tu clase personalizada

        GameView view = new GameView();          // 👈 vista
        Controlador controller = new Controlador(view); // 👈 controlador

        Scene scene = new Scene(view, 720, 480);

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