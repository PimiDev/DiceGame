package GUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DiceView extends ImageView {

    private int valor;


    public DiceView() {
        this.valor = 1;
        actualizarVista();
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

            Image nuevaImg = new Image(getClass().getResource(ruta).toExternalForm());
            this.setImage(nuevaImg);
        } catch (Exception e) {
            System.err.println("No se encontró la imagen del dado: " + valor);
        }
    }
}