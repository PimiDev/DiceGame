package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonesView extends VBox {

    private Button startButton;
    private Button rollButton;
    private Button moveButton;

    public BotonesView(){
        startButton = new Button("Start");
        rollButton = new Button("Roll");
        moveButton = new Button("Move");

        startButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-border-radius: 3;");
        rollButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-border-radius: 3;");
        moveButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-border-radius: 3;");

        this.setAlignment(Pos.CENTER);

        this.setSpacing(20);

        startButton.setAlignment(Pos.TOP_RIGHT);
        rollButton.setAlignment(Pos.TOP_RIGHT);
        moveButton.setAlignment(Pos.TOP_RIGHT);
        this.setStyle("-fx-background-color:#78FF95;");
        this.setMinWidth(200);
        getChildren().addAll(startButton,rollButton,moveButton);
    }
}
