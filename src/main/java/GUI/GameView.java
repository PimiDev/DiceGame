package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane { // <--- CAMBIA HBox por BorderPane

    BoardView boardView;
    BotonesView botonesView;

    public GameView(){
        this.setPrefSize(720, 480);
        this.setMaxSize(720, 480);
        this.setMinSize(720, 480);
        // Fondo oscuro para todo el juego
        this.setStyle("-fx-background-color: #0E0B16;");
        this.setPadding(new Insets(10));

        boardView = new BoardView();
      //  boardView.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
       boardView.setScaleX(0.3);
        boardView.setScaleY(0.3);

        botonesView = new BotonesView();
        botonesView.setPrefWidth(150); // ajusta este valor
        botonesView.setMaxWidth(150);
        // 1. Ponemos los botones a la IZQUIERDA
        this.setLeft(botonesView);
        BorderPane.setAlignment(botonesView, Pos.CENTER);
        BorderPane.setMargin(botonesView, new Insets(0, 20, 0, 0)); // Espacio con el tablero

        // 2. El tablero en el CENTRO (se expande solo)
        this.setCenter(boardView);
        BorderPane.setAlignment(boardView, Pos.CENTER);
    }

    public BoardView getBoardView() {
        return boardView;
    }
    public BotonesView getBotonesView(){
        return botonesView;
    }
}