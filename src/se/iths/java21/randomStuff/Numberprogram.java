package se.iths.java21.randomStuff;

import java.util.ArrayList;
import java.util.Scanner;

public class Numberprogram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the number!, between 1-100");

        int secretNumber = (int) (Math.random()*101);
        int guess = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(guess != secretNumber){
            guess = scanner.nextInt();
            if(guess > secretNumber){
                System.out.println("A little too high!");
                list.add(guess);
            }else if(guess == secretNumber){
                System.out.println("Correct!");
                System.out.println();
                System.out.println("Here are you guesses!");
                for(int x : list){
                    System.out.printf( list.indexOf(x) + 1 + ". Guess was %d \n",x);
                }
            }
            else{
                System.out.println("A little too low");
                list.add(guess);
            }
        }

    }
}
