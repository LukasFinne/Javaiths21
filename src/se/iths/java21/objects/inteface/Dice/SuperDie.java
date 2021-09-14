package se.iths.java21.objects.inteface.Dice;


public abstract class SuperDie implements Die{
    protected int currentSide;//protected är som private men sub klasser får modifera den
    private int sides;

    public SuperDie(int sides){
        this.sides = sides;
        currentSide = 1;
    }

    @Override
    public abstract void roll();

    @Override
    public int value() {
        return currentSide;
    }

    @Override
    public int numberOfSides() {
        return sides;
    }
}
