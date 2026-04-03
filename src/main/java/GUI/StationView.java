package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class StationView extends GridPane {

    private DiceView diceView;
    private ImageView avatar;
    private int numeroEstacion;
    private int numeroPersonas;
    private Label lblPersonas;

    public StationView(){
        this.getStyleClass().add("grid-pane");
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(5));
        this.setHgap(8);


        this.setMinWidth(130);
        this.setMaxWidth(140);
        this.setMinHeight(180);
        this.setMaxHeight(200);

        diceView = new DiceView();
        avatar = new ImageView();
        lblPersonas = new Label("0");
        lblPersonas.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #ffffff; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 5, 0, 0, 0);");

        diceView.setPreserveRatio(true);
        diceView.setFitWidth(45);

        avatar.setPreserveRatio(true);
        avatar.setFitWidth(75);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(50);
        c1.setHalignment(javafx.geometry.HPos.CENTER);

        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPercentWidth(50);
        c2.setHalignment(javafx.geometry.HPos.CENTER);

        this.getColumnConstraints().addAll(c1, c2);

        this.add(diceView, 0, 0);
        this.add(avatar, 1, 0);
        this.add(lblPersonas, 1, 1);
    }

    public void setCantidadPersonas(int cantidad) {
        lblPersonas.setText(String.valueOf(cantidad));
    }

    public void setNumeroEstacion(int n){
        numeroEstacion = n;
        setAvatar();
    }

    public void setAvatar() {
        try {

            String ruta = "/GUI/Avatares/" + numeroEstacion + ".png";
            Image nuevaImg = new Image(getClass().getResource(ruta).toExternalForm());
            avatar.setImage(nuevaImg);
        } catch (Exception e) {
            System.err.println("No se encontró la imagen de la estacion: " + numeroEstacion);
        }
    }

    public DiceView getDiceView() { return diceView; }
}