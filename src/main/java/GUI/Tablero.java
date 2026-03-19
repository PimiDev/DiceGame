package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button; // ¡Usa este, no el de Swing!
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Tablero extends HBox {

    private Button startButton;
    private Button rollButton;
    private Button moveButton;

    private String formatoBoton =  "-fx-background-color: #27ae60; " + // Color de fondo (verde)
            "-fx-text-fill: white; " +           // Color de la letra
            "-fx-font-size: 14px; " +            // Tamaño de letra
            "-fx-background-radius: 15; " +      // Bordes redondeados
            "-fx-font-weight: bold;";             // Negrita

    private VBox buttonsColumns;
    private GridPane stationsPane;

    public Tablero() {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10);
        this.setPadding(new Insets(10));

        startButton = new Button("Start Game");
        rollButton = new Button("Roll Dice");
        moveButton = new Button("Move Units");


        startButton.setMaxWidth(Double.MAX_VALUE);
        rollButton.setMaxWidth(Double.MAX_VALUE);
        moveButton.setMaxWidth(Double.MAX_VALUE);

        buttonsColumns = new VBox(10);
        buttonsColumns.setPrefWidth(140);
        buttonsColumns.setAlignment(Pos.TOP_CENTER);
        buttonsColumns.setStyle("-fx-background-color: #34495e; -fx-padding: 10;");

        embellecerBoton(startButton);
        embellecerBoton(rollButton);
        embellecerBoton(moveButton);

        buttonsColumns.getChildren().addAll(startButton, rollButton, moveButton);


        stationsPane = new GridPane();
        stationsPane.setStyle("-fx-background-color: #ecf0f1;");
        HBox.setHgrow(stationsPane, Priority.ALWAYS);

        this.getChildren().addAll(buttonsColumns, stationsPane);
    }

    public void embellecerBoton(Button bt) {
        bt.setStyle(formatoBoton);

    }

}