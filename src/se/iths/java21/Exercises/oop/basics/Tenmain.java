package se.iths.java21.Exercises.oop.basics;

public class Tenmain {

    public static void main(String[] args) {
        Ten pancake = new Ten(3,3,3,0,3);

        System.out.println(pancake.canMakePancakes());
        pancake.makePancakes();
    }
}
