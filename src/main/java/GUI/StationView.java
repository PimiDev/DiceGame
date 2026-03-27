package GUI;

import Logic.Dice;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class StationView extends GridPane {

    private int cantidadActual;
    private DiceView diceView;
    private ImageView avatar;
    private int numeroEstacion;
    private int numeroPersonas;
    private PeopleView peopleView;

    public StationView(){
        this.getStyleClass().add("grid-pane");
        numeroPersonas = 0;

        diceView = new DiceView();


        avatar = new ImageView();
        avatar.setFitWidth(250);
        avatar.setPreserveRatio(true);
        avatar.setSmooth(true);

        peopleView = new PeopleView();
       // peopleView.actualizarPersonas(4);//inicia con 4

        this.add(diceView, 0, 0);
        this.add(peopleView,0,1);
        this.add(avatar,1,0);

       // setNumeroEstacion(1);//predeterminado 1
    }
    public void setNumeroEstacion(int n){
        numeroEstacion = n;
        setAvatar();
    }

    public void actualizarPersonas(int n){
        peopleView.actualizarPersonas(n);
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
    // Agrega esto a StationView.java
    public DiceView getDiceView() { return diceView; }
    public PeopleView getPeopleView() { return peopleView; }
    }

