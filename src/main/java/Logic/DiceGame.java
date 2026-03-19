package Logic;

public class DiceGame {

     private WorkStation[] workStations;
     private int stationsAmount; //cantidad de estaciones
     private int procesosTerminados;
     private int turno;
    public DiceGame(int stationsAmount){
         this.stationsAmount = stationsAmount;
         workStations = new WorkStation[this.stationsAmount];
         procesosTerminados = 0;
         turno = 0;
    }
    public int getStationsAmount() {
        return stationsAmount;
    }
    public void setStationsAmount(int stationsAmount) {
        this.stationsAmount = stationsAmount;

    }
    public void crearEstaciones(){ // llena el array con estaciones reales
        for (int i = 0; i < this.stationsAmount; i++) {
            workStations[i] = new WorkStation(i);
        }
    }
    //Anade 4 personas pendientes del dia anterior a cada estacion
    public void inicializarPendientes(){
        boolean firstStation = true;
        for(WorkStation ws : workStations){
            if(firstStation){
                ws.setCantidadPendiente(0);
                firstStation = false;
                System.out.printf("primero no tiene pendientes\n");
            }else{
                ws.setCantidadPendiente(4);
            }
        }
        System.out.println("estaciones inicializadas\n");
    }

    public void lanzarDados(){
        for(WorkStation ws : workStations){
            ws.setCapacidadActual(ws.rollDice()); //cada uno lanza el dado y el resultado es su capacidad
        }
    }

    public String toString(){
        String estaciones = "";
        for(WorkStation ws : workStations){
            estaciones += ws.toString();
        }
        return estaciones;
    }

    public static void main(String[] args) {
        //tratar al primero y al utlimo diferente
        DiceGame dg = new DiceGame(10);
        dg.crearEstaciones();
        //todos tienen 4 pendientes en el primer turno
        dg.inicializarPendientes();

        System.out.println(dg.toString());
        //COMIENZA
        dg.lanzarDados();
        //lanzan dado todos
        System.out.printf(dg.toString());
        //aceptan a los que pueden

        //actualizamos datos

        //comeinza de nuevo
    }
}

