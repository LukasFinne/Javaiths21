package se.iths.java21.patterns.structural.decorator;

public abstract class PizzaDecorator extends Pizza {
    private Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }


    protected Pizza getPizza(){
        return pizza;
    }
}
