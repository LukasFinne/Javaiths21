package se.iths.java21.patterns.behavioral.strategy;

public class MultiLinePrinting implements PrintingStrategy{

    @Override
    public void print(Person person) {
        System.out.println("Person");
        System.out.println("Name:" + person.name());
        System.out.println("Age:" + person.age());
    }
}
