package se.iths.java21.Exercises.oop.basics;

public class Seven {
    static int noOfObjects = 0;

    {
        noOfObjects += 1;
    }

    private int counter;


    public Seven(int counter) {
        this.counter = counter;
    }
    public Seven(String s) {

    }
    public int printObjects(){
        return noOfObjects;
    }
    public int printValue(){
        return counter;
    }

    public int increase(){
        return ++counter;
    }

    public int decrease(){
        return --counter;
    }


}
