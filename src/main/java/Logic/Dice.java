package Logic;

import java.util.Random;

public class Dice {
    private int sides;
    private int lastValue;
    private Random random;

    public Dice() {
        this.sides = 6;
        this.random = new Random();
        roll();//se lanza para que no comienze en cero
    }

    // Genera un numero del 1 al 6
    public int roll() {
        this.lastValue = random.nextInt(sides) + 1;
        return lastValue;
    }

    // Getter para consultar el ultimo valor del dado
    public int getLastValue() {
        return lastValue;
    }
}