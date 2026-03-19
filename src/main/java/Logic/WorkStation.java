package Logic;

public class WorkStation {

    private int id; // numero de estacion
    private Dice dice;
    private int capacidadActual; // resultado del dado
    private int cantidadPendiente; // cantidad total en espera

    public WorkStation(int id , boolean primeraEstacion){
        this.id = id;
        dice = new Dice();
    }

    public int rollDice(){
        dice.roll(); // lanza el dado
        return dice.getLastValue(); // retorna el valor dado
    }

    //GETTERS Y SETTERS
    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

    public void setCapacidadActual(int n){capacidadActual = n;}
    public int getCapacidadActual(){return capacidadActual;}

    public void incrementarCantidadPendiente(int n){cantidadPendiente+=n;}
    public void setCantidadPendiente(int cantidadPendiente) {this.cantidadPendiente = cantidadPendiente;}
    public int getCantidadPendiente(){return cantidadPendiente;}

}
