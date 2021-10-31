package se.iths.java21.patterns.structural.decorator;

public class Margherita extends Pizza{

    @Override
    public String getDescription() {
        return "Cheese, Tomato sauce";
    }

    @Override
    public int getCost() {
        return 60;
    }
}
