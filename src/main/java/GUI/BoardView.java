package GUI;

import Logic.WorkStation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

public class BoardView extends GridPane {

    private ArrayList<StationView> vistasEstaciones;

    public BoardView() {

        // Estilo del borde izquierdo
        this.setStyle(
                "-fx-border-width: 0 0 0 3; " +
                        "-fx-border-color: #A239CA;"
        );

        this.setHgap(0);
        this.setVgap(0);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);

        vistasEstaciones = new ArrayList<>();

        int columnas = 5; // 5 columnas → 2 filas de 10 estaciones

        for (int i = 0; i < 10; i++) {
            StationView sv = new StationView();
            sv.setNumeroEstacion(i + 1);

            // 🔧 IMPORTANTE: tamaño fijo para que todo quepa
           sv.setPrefSize(120, 150);

            vistasEstaciones.add(sv);

            int col = i % columnas;
            int row = i / columnas;

            this.add(sv, col, row);
        }
    }

    public void sincronizarConLogica(WorkStation[] logicaEstaciones) {
        for (int i = 0; i < logicaEstaciones.length; i++) {
            WorkStation ws = logicaEstaciones[i];
            StationView vista = vistasEstaciones.get(i);

            // Actualizar dado
            vista.getDiceView().setValor(ws.getValorActual());

            // Calcular personas en cola
            int enCola = 0;
            if (!ws.getCola().colaVacia()) {
                enCola = ws.getCola().getFin() - ws.getCola().getInicio() + 1;
            }

            // Actualizar visual
            vista.getPeopleView().actualizarPersonas(enCola);
        }
    }
}