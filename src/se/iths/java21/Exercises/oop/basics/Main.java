package se.iths.java21.Exercises.oop.basics;

public class Main {

    public static void main(String[] args) {
        One cat = new One(true, true, true);
        One fish = new One(true, false, false);
        System.out.println(cat.isPredator());
        System.out.println(fish.isLandWalker());


        Seven counter = new Seven(7);
        Seven sas = new Seven("Hello");
        counter.decrease();
        System.out.println(counter.printValue());
        counter.increase();
        System.out.println(counter.printValue());
        counter.increase();
        System.out.println(counter.printObjects());



    }

}
