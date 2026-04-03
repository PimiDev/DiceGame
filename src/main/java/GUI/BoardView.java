package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import java.util.ArrayList;

public class BoardView extends GridPane {

    private ArrayList<StationView> vistasEstaciones;

    public BoardView() {
        // 1. Configuración del contenedor (fijamos tamaño para que no explote)
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(15);
        this.getStyleClass().add("board-view");

        // Evitamos que el tablero sea más grande que la ventana de 720x480
        this.setMaxWidth(720);
        this.setMaxHeight(480);

        vistasEstaciones = new ArrayList<>();

        // 2. Definir 5 COLUMNAS (fijas al 20% pero sin empujar de más)
        for (int i = 0; i < 5; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(20);
            col.setHalignment(javafx.geometry.HPos.CENTER);
            // Quitamos el Priority.ALWAYS para que no force el crecimiento
            this.getColumnConstraints().add(col);
        }

        // 3. Definir 2 FILAS (Quitamos el 50% de alto para que no se hagan gigantes)
        for (int i = 0; i < 2; i++) {
            RowConstraints row = new RowConstraints();
            // Usamos PREF_SIZE para que la fila solo mida lo que mide el StationView hardcodeado
            row.setVgrow(Priority.SOMETIMES);
            row.setValignment(javafx.geometry.VPos.CENTER);
            this.getRowConstraints().add(row);
        }

        inicializarEstaciones();
    }

    private void inicializarEstaciones() {
        int contador = 0;
        for (int fila = 0; fila < 2; fila++) {
            for (int col = 0; col < 5; col++) {
                StationView station = new StationView();
                station.setNumeroEstacion(contador + 1);

                vistasEstaciones.add(station);
                this.add(station, col, fila);

                contador++;
            }
        }
    }

    public ArrayList<StationView> getVistasEstaciones() {
        return vistasEstaciones;
    }
}