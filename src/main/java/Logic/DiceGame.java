package Logic;

public class DiceGame {

    private WorkStation[] estaciones;

    private int totalEntregado;        // acumulado ✔
    private int salieronUltimoTurno;   // último turno ✔

    public DiceGame(int nEstaciones){

        estaciones = new WorkStation[nEstaciones];
    }

    public void inicializarEstaciones(){
        for(int i = 0; i < estaciones.length; i++){
            estaciones[i] = new WorkStation();
        }
    }

    public void lanzarDados(){
        for(WorkStation ws : estaciones){
            ws.rollDice();
        }
    }
    public void inicializarPendientes(){
        for(int i = 1; i < estaciones.length; i++){
            for(int j = 0 ; j<=3 ; j++){
                estaciones[i].incrementarCola(new People(true));
            }
        }
    }
    public void moverUnidades() {
        salieronUltimoTurno = 0;


        for (int i = estaciones.length - 1; i >= 1; i--) {
            WorkStation actual = estaciones[i];
            int capacidad = actual.getValorActual();

            for (int j = 0; j < capacidad; j++) {
                if (!actual.getCola().colaVacia()) {
                    People p = actual.procesarPeople();

                    if (i < estaciones.length - 1) {
                        estaciones[i + 1].incrementarCola(p);
                    } else {
                        // Es la última estación, salen del sistema
                        totalEntregado++;
                        salieronUltimoTurno++;
                    }
                } else {
                    break;
                }
            }
        }

        // 2. El primero (Estación 0) genera nueva gente para la Estación 1
        int nuevosClientes = estaciones[0].getValorActual();
        for (int j = 0; j < nuevosClientes; j++) {
            estaciones[1].incrementarCola(new People(false));
        }
    }

    public WorkStation[] getEstaciones(){
        return estaciones;
    }

    public int getSalieronUltimoTurno() {
        return salieronUltimoTurno;
    }

    public int getTotalEntregado() {
        return totalEntregado;
    }

    public static void main(String[] args) {
        // crear juego con 5 estaciones
        DiceGame juego = new DiceGame(5);

        //crea estaciones y da 4 pendientes
        juego.inicializarEstaciones();
        juego.inicializarPendientes();

        System.out.println("=== INICIO DE LA SIMULACION ===");

        // se corren 5 dias para probar
        for (int dia = 1; dia <= 5; dia++) {
            System.out.println("\n>>>> DÍA " + dia + " <<<<");

            //lanzar dados para ver capacidades
            juego.lanzarDados();

            //capacidades de cada estacionn
            System.out.print("Capacidades de hoy: ");
            for (int i = 0; i < juego.estaciones.length; i++) {
                System.out.print("[E" + i + ": " + juego.estaciones[i].getValorActual() + "] ");
            }
            System.out.println();

            //movimiento de gentre
            juego.moverUnidades();

            // cuanta gentte quedo en cola despuies de movimientos
            System.out.print("Estado de las colas: ");
            for (int i = 0; i < juego.estaciones.length; i++) {
                // fin - inicio + 1
                int enCola = 0;
                if(!juego.estaciones[i].getCola().colaVacia()){
                    enCola = juego.estaciones[i].getCola().getFin() - juego.estaciones[i].getCola().getInicio() + 1;
                }
                System.out.print("[E" + i + ": " + enCola + " pers.] ");
            }
            System.out.println("\n-------------------------------------------");
        }

        System.out.println("\n=== SIMULACION TERMINADA :v ===");
    }
}

