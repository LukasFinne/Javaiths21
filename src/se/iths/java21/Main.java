package se.iths.java21;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Guess the number!, betwenn 1-100");



        int hemligt = (int) (Math.random()*101);
        int guess = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while(guess != hemligt){
             guess = sc.nextInt();
             if(guess > hemligt){
                 System.out.println("A little too high!");
                 list.add(guess);

             }else if(guess == hemligt){
                 System.out.println("Correct!");

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
