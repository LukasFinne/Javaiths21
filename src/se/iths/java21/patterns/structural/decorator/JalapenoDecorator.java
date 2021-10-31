package se.iths.java21.patterns.structural.decorator;

public class JalapenoDecorator extends PizzaDecorator {
    public JalapenoDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return getPizza().getDescription() + ", Jalapeno";
    }

    @Override
    public int getCost() {
        return 5 + getPizza().getCost();
    }
}
