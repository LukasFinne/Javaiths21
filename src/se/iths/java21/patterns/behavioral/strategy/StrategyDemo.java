package se.iths.java21.patterns.behavioral.strategy;

public class StrategyDemo {


    public static void main(String[] args) {
        Person person = new Person("Kalle", 22);
        PrintingStrategy printingStrategy = new SameLinePrinting();
        printingStrategy.print(person);

        PrintingStrategy printingStrategy2 = new MultiLinePrinting();
        printingStrategy2.print(person);



    }
}
