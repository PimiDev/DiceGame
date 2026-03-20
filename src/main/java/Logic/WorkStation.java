package Logic;

public class WorkStation {

    private Cola<People> cola;
    private Dice dice;
    private int valorActual;
    public WorkStation(){
        cola = new Cola<People>();
        dice = new Dice();
        valorActual = 1;
    }

    public void rollDice(){
       valorActual = (dice.roll());
    }

    public void incrementarCola(People people){
        cola.insertar(people);
    }

    public People procesarPeople(){
        return cola.eliminar();
    }

    public int getValorActual(){
        return valorActual;
    }

    public Cola<People> getCola() {
        return cola;
    }
}
