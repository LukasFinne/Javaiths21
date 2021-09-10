package se.iths.java21.Exercises.oop.basics;

public class Ten {
    private int flour;
    private int milk;
    private int egg;
    private int salt;
    private int butter;
    int numberOfPancakes = 0;

    public Ten(int flour, int milk, int egg, int salt, int butter) {
        this.flour = flour;
        this.milk = milk;
        this.egg = egg;
        this.salt = salt;
        this.butter = butter;
    }

    public boolean canMakePancakes(){
        return flour >= 1 &&
                milk >= 1 &&
                egg >= 1 &&
                salt >= 1 &&
                butter >= 1;
    }

    public void makePancakes(){

        if(flour >= 1 && milk >= 1 && egg >= 1 && salt >= 1 && butter >= 1){
            flour--;
            milk--;
            egg--;
            salt--;
            butter--;
            numberOfPancakes += 1;
            System.out.printf("Making Pancake No. %d \n", numberOfPancakes);
            makePancakes();

        }else
            System.out.println("Not enough resources!");


    }

}
