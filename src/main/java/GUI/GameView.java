package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class GameView extends HBox {

    private BotonesView botones;
    private BoardView tablero;

    public GameView() {

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(10));
        this.setSpacing(20);
        this.setStyle("-fx-background-color: #0E0B16");

        this.setMaxSize(1080, 480);
        this.setPrefSize(1080, 480);


        botones = new BotonesView();
        tablero = new BoardView();


        HBox.setHgrow(botones, Priority.ALWAYS);


        botones.setMaxHeight(Double.MAX_VALUE);
        botones.setMaxWidth(Double.MAX_VALUE);


        HBox.setHgrow(tablero, Priority.NEVER);


        this.getChildren().addAll(botones, tablero);
    }

    public BotonesView getBotones() { return botones; }
    public BoardView getTablero() { return tablero; }
}
