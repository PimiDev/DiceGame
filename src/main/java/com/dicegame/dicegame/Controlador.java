package com.dicegame.dicegame;

import GUI.GameView;
import Logic.DiceGame;

public class Controlador {

    private DiceGame diceGame;
    private GameView gameView;
    private int turnos;

    public Controlador(GameView gameView){
        this.gameView = gameView;

        diceGame = new DiceGame(10);
        turnos = 20;

        setAccionesBotones();
    }

    public void setAccionesBotones(){

        gameView.getBotonesView().getStartButton().setOnAction(actionEvent -> {

            // reiniciar todo
            diceGame = new DiceGame(10);
            turnos = 20;

            diceGame.inicializarEstaciones();
            diceGame.inicializarPendientes();

            // actualizar vista SIEMPRE desde el modelo
            gameView.getBoardView().sincronizarConLogica(diceGame.getEstaciones());

            gameView.getBotonesView().setStartView(false);
            gameView.getBotonesView().setRollView(true);
        });

        gameView.getBotonesView().getRollButton().setOnAction(actionEvent -> {

            diceGame.lanzarDados();

            gameView.getBoardView().sincronizarConLogica(diceGame.getEstaciones());

            gameView.getBotonesView().setRollView(false);
            gameView.getBotonesView().setMoveView(true);
        });

        gameView.getBotonesView().getMoveButton().setOnAction(actionEvent -> {

            diceGame.moverUnidades();
            turnos--;

            gameView.getBoardView().sincronizarConLogica(diceGame.getEstaciones());


            gameView.getBotonesView().setMoveView(false);
            gameView.getBotonesView().setRollView(true);
        });
    }
}