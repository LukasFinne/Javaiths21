package se.iths.java21.exercises.oop.advanced;

public class Vehicle {


    public Vehicle(){

    }

    public static void main(String[] args) {
        Vehicle test = new Vehicle();
        Vehicle bicycle = new Bicycle();
        Vehicle bil = new Bil();


        test.goTo("Test");
        bicycle.goTo("Stranden");
        bil.goTo("Stockholm");
    }


    void goTo(String x){
        System.out.println("Färdas till " + x);
    }
}


class Bicycle extends Vehicle{
    void goTo(String x){
        System.out.println("Färdas med cykel till " + x);
    }
}

class Bil extends Bicycle{
    void goTo(String x){
        System.out.println("Färdas med bil till " + x);
    }
}