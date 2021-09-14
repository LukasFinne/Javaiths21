package se.iths.java21.objects.inteface.Dice;

import java.util.Random;

public class SixSidedDie implements Die{
    //Konstruktor job är att inisliera objekt
    private int currentSide;
    private Random random; //vi lägger random objektet som ett fält
    // och inte i roll metoden för vi vill inte skapa ett nytt random objekt varje gång vi kallar roll metoden
    public SixSidedDie(){
        currentSide = 1;
        random = new Random();
    }


    @Override
    public void roll() {
        currentSide = random.nextInt(6) + 1;
    }

    @Override
    public int value() {
        return currentSide;
    }

    @Override
    public int numberOfSides() {
        return 6;
    }
}
