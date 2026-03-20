package GUI;

import javafx.scene.layout.HBox;

public class TableroView extends HBox {

    BotonesView botones;

    public TableroView(){

        botones = new BotonesView();
        getChildren().addAll(botones);

    }

}
