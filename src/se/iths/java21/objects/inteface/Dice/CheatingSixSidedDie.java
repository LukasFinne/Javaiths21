package se.iths.java21.objects.inteface.Dice;

import se.iths.java21.objects.inteface.Dice.Die;

public class CheatingSixSidedDie implements Die {

    @Override//Verifera metoder så vi verklingen erssätter den och inte skapar en ny
    public void roll() {

    }

    @Override
    public int value() {
        return 6;
    }

    @Override
    public int numberOfSides() {
        return 6;
    }
}
