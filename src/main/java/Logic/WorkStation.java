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

    public WorkStation copiar() {
        WorkStation copia = new WorkStation();

        // copiar valor del dado
        copia.valorActual = this.valorActual;

        //copiar la cola
        Cola<People> colaOriginal = this.cola;
        Cola<People> colaAux = new Cola<>();
        Cola<People> colaCopia = new Cola<>();

        while (!colaOriginal.colaVacia()) {
            People p = colaOriginal.eliminar();

            colaAux.insertar(p);     // para restaurar
            colaCopia.insertar(p);   // copia real
        }

        // restaurar original
        while (!colaAux.colaVacia()) {
            colaOriginal.insertar(colaAux.eliminar());
        }

        // asignar copia
        copia.cola = colaCopia;

        return copia;
    }
}
