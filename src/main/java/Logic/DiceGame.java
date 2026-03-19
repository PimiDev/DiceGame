package Logic;

public class DiceGame {

     private WorkStation[] workStations;
     private int stationsAmount; //cantidad de estaciones
     private int procesosTerminados;

    public DiceGame(int stationsAmount){
         this.stationsAmount = stationsAmount;
         workStations = new WorkStation[this.stationsAmount];
         procesosTerminados = 0;
    }
    public int getStationsAmount() {
        return stationsAmount;
    }
    public void setStationsAmount(int stationsAmount) {
        this.stationsAmount = stationsAmount;

    }

    //Anade 4 procesos pendientes a cada estacion, a excepcion del primero
    public void inicializarProcesos(){
        boolean firstStation = true;
        for(WorkStation ws : workStations){
            if(firstStation){
                ws.setCantidadPendiente(0);
                firstStation = false;
            }else{
                ws.setCantidadPendiente(4);
            }
        }
    }

    public static void main(String[] args) {
        //tratar al primero y al utlimo diferente

        //todos tienen 4 pendientes en el primer turno

        //COMIENZA

        //lanzan dado todos

        //aceptan a los que pueden

        //actualizamos datos

        //comeinza de nuevo
    }
}

