package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PeopleView extends GridPane {

    private final Color AMARILLO = Color.web("#FDFD96");


    private final int COLUMNAS = 6;

    public PeopleView() {
        this.setHgap(4);
        this.setVgap(4);
        this.setPadding(new Insets(5));
        this.setAlignment(Pos.CENTER);
    }


    public void actualizarPersonas(int cantidad) {

        this.getChildren().clear();

        for (int i = 0; i < cantidad; i++) {

            Circle bolita = crearBolita();

            int col = i % COLUMNAS;
            int row = i / COLUMNAS;

            this.add(bolita, col, row);
        }
    }

    private Circle crearBolita() {
        Circle c = new Circle(5);
        c.setFill(AMARILLO);
        return c;
    }
}