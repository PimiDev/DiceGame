package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;

public class BotonesView extends VBox {

    private Button start;
    private Button roll;
    private Button move;
    private Label turnoActual;
    private Label fueraDeSistema;

    public BotonesView() {
        this.setAlignment(Pos.CENTER);

        this.getStyleClass().add("vbox");


        this.setMinWidth(160);

        turnoActual = new Label("Turno actual: 0");
        fueraDeSistema = new Label("Clientes fuera: 0");

        this.getChildren().add(turnoActual);
        this.getChildren().add(fueraDeSistema);
        inicializarBotones();
    }

    private void inicializarBotones() {
        start = new Button("Start");
        roll = new Button("Roll");
        move = new Button("Move");

        start.setMaxWidth(Double.MAX_VALUE);
        roll.setMaxWidth(Double.MAX_VALUE);
        move.setMaxWidth(Double.MAX_VALUE);



        // Agregamos los botones al VBox
        this.getChildren().addAll(start, roll, move);
    }

    public void setStartView(boolean b) {
        start.setVisible(b);
        start.setManaged(b);
    }

    public void setRollView(boolean b) {
        roll.setVisible(b);
        roll.setManaged(b);
    }

    public void setMoveView(boolean b) {
        move.setVisible(b);
        move.setManaged(b);
    }

    public void setTurnoActual(int n){
        turnoActual.setText("Turno actual: "+n);
    }
    public void setClientesFuera(int n){
        fueraDeSistema.setText("Clientes fuera: "+n);
    }

    public Button getStartButton() { return start; }
    public Button getRollButton() { return roll; }
    public Button getMoveButton() { return move; }
}