package se.iths.java21.patterns.structural.decorator;

public class PizzaDecoratorDemo {

    public static void main(String[] args) {
        Pizza pizza = new Margherita();

        pizza = new JalapenoDecorator( new JalapenoDecorator(pizza));

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());
    }
}
