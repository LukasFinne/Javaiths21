package se.iths.java21.Exercises.oop.basics;

public class Seven {
    static int noOfObjects = 0;

    {//Ett sätt initiera static fält
        noOfObjects += 1;
    }

    private int counter; // default value 0
    private String name; //default value null

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
