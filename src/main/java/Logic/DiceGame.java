package Logic;

public class DiceGame {

    private WorkStation[] estaciones;
    private int totalEntregado = 0;

    public DiceGame(int nEstaciones){
        estaciones = new WorkStation[10];
    }


    //crear las estaciones
    public void inicializarEstaciones(){
        for(int i = 0; i < estaciones.length; i++){
            estaciones[i] = new WorkStation();
        }
    }
    //todos lanzan los dados
    public void lanzarDados(){
        for(WorkStation ws : estaciones){
            ws.rollDice();
        }
    }

    public void inicializarPendientes(){
        for(int i = 1; i < estaciones.length ; i++){
            for(int j = 0 ; j<=3 ; j++){
                estaciones[i].incrementarCola(new People(true));
            }
        }
    }

    public void moverUnidades() {
        // estaciones de la 1 a la N
        // Recorremos desde la última hasta la SEGUNDA
        for (int i = estaciones.length - 1; i > 0; i--) {
            WorkStation actual = estaciones[i];
            int capacidad = actual.getValorActual();

            for (int j = 0; j < capacidad; j++) {
                if (!actual.getCola().colaVacia()) {
                    People p = actual.procesarPeople();

                    // si no es ultima pasa a la siguiente
                    if (i < estaciones.length - 1) {
                        estaciones[i + 1].incrementarCola(p);
                    } else {
                        // Si es la última, el cliente sale del sistema :v
                        System.out.println("Cliente fuera del sistema.");
                    }
                }
            }
        }

        // estacion numero 0
        // Esta no saca de su cola, sino que genera nuevos clientes
        WorkStation primera = estaciones[0];
        int nuevosClientes = primera.getValorActual();
        for (int j = 0; j < nuevosClientes; j++) {
            People nuevo = new People(false); // cramos gente
            // pasa la gente a la estacion 1
            estaciones[1].incrementarCola(nuevo);
        }
        System.out.println("Se generaron " + nuevosClientes + " nuevos clientes en la entrada.");
    }
    public static void main(String[] args) {
        // crear juego con 5 estaciones
        DiceGame juego = new DiceGame(5);

        //crea estaciones y da 4 pendientes
        juego.inicializarEstaciones();
        juego.inicializarPendientes();

        System.out.println("=== INICIO DE LA SIMULACIÓN ===");

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
                // Usamos el método que saca la cantidad real (fin - inicio + 1)
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

