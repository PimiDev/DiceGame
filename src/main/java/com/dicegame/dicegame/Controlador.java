package com.dicegame.dicegame;

import Logic.DiceGame;
import GUI.GameView;
import GUI.StationView;
import Logic.WorkStation;
import java.util.ArrayList;

public class Controlador {

    private DiceGame diceGame;
    private GameView vista;
    private int turnoActual;

    public Controlador(GameView vista) {
        this.vista = vista;
        this.diceGame = new DiceGame(10);
        this.turnoActual = 0;


        diceGame.inicializarEstaciones();
        diceGame.inicializarPendientes();


        vista.getBotones().setRollView(true);
        vista.getBotones().setMoveView(false);
        vista.getBotones().setStartView(false);


        setAccionesBotones();


        actualizarInterfaz();
    }

    public void setAccionesBotones() {

        vista.getBotones().getRollButton().setOnAction(e -> {
            diceGame.lanzarDados();


            vista.getBotones().setRollView(false);
            vista.getBotones().setMoveView(true);

            actualizarInterfaz();
        });


        vista.getBotones().getMoveButton().setOnAction(e -> {
            diceGame.moverUnidades();
            turnoActual++;
            vista.getBotones().setTurnoActual(turnoActual);
            // Volver a Roll
            vista.getBotones().setClientesFuera(diceGame.getTotalEntregado());

            vista.getBotones().setRollView(true);
            vista.getBotones().setMoveView(false);

            actualizarInterfaz();


            if (turnoActual >= 20) {
                System.out.println("Juego Terminado. Total entregado: " + diceGame.getTotalEntregado());
                vista.getBotones().setRollView(false);
                vista.getBotones().setMoveView(false);
            }
        });
    }


    private void actualizarInterfaz() {
        WorkStation[] estacionesLogica = diceGame.getEstaciones();
        ArrayList<StationView> estacionesVista = vista.getTablero().getVistasEstaciones();

        for (int i = 0; i < estacionesLogica.length; i++) {
            if (i < estacionesVista.size()) {
                WorkStation ws = estacionesLogica[i];
                StationView sv = estacionesVista.get(i);


                sv.getDiceView().setValor(ws.getValorActual());
                int enCola = 0;
                if (ws.getCola() != null && !ws.getCola().colaVacia()) {
                    enCola = ws.getCola().getFin() - ws.getCola().getInicio() + 1;
                }

                sv.setCantidadPersonas(enCola);
            }
        }
    }
}