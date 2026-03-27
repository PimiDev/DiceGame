package GUI;

import Logic.WorkStation;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class WorkStationView extends GridPane {

    private WorkStation ws;
    private ImageView avatar;
    private ImageView dadoAvatar;
    public WorkStationView(WorkStation ws , ImageView avatar){
        this.ws = ws;
        this.avatar = avatar;
        Image imagenDado = new Image(
                getClass().getResource("/dado1.png").toExternalForm()
        );

        dadoAvatar = new ImageView(imagenDado);

        setConstraints(avatar,0,0);
        setConstraints(dadoAvatar,1,0);
        getChildren().addAll(avatar,dadoAvatar);
    }

    public void actualizarDadoGrafico(int n){

    }




}
