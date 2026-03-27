package GUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DiceView extends ImageView { // <--- Directo al grano

    private int valor;

    public DiceView() {
        this.valor = 1;
        // Configuración inicial
        actualizarVista();

        // Esto hace que si lo metes en un GridPane, respete el tamaño que le des
        this.setFitWidth(60);
        this.setFitHeight(60);
        this.setPreserveRatio(true);
        this.setSmooth(true);
    }

    public void setValor(int valor) {
        this.valor = valor;
        actualizarVista();
    }

    private void actualizarVista() {
        try {
            String ruta = "/GUI/Dado/" + valor + ".png";
            // Cargamos la imagen y se la asignamos a "this" (porque somos un ImageView)
            Image nuevaImg = new Image(getClass().getResource(ruta).toExternalForm());
            this.setImage(nuevaImg);
        } catch (Exception e) {
            System.err.println("No se encontró la imagen del dado: " + valor);
        }
    }
}