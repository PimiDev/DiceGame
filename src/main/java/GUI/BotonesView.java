package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonesView extends VBox {

    private Button start;
    private Button roll;
    private Button move;

    public BotonesView(){
        setAlignment(Pos.CENTER);
        setSpacing(20);
        this.getStyleClass().add("vbox");
        inicializarBotones();
    }

    private void inicializarBotones(){
        start = new Button("Start");
        roll = new Button("Roll");
        move = new Button("Move");

        roll.setVisible(false);
        move.setVisible(false);

        getChildren().addAll(start,roll,move);
    }
    //getters
    public Button getStartButton() { return start; }
    public Button getRollButton() { return roll; }
    public Button getMoveButton() { return move; }

    public void setStartView(boolean b){
        start.setVisible(b);
    }
    public void setRollView(boolean b){
        roll.setVisible(b);
    }
    public void setMoveView(boolean b){
        move.setVisible(b);
    }
}
