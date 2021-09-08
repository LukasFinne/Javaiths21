package se.iths.java21.Lab;

import java.util.Random;
import java.util.Scanner;

public class Rockpaperscissors {

    public void rockPaperScissors(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv sten, sax, eller påse");
        String userChoice = sc.next().toLowerCase();
        result(userChoice,computerChoice());
    }

    public static void result(String userChoice, String computerChoice){

        if(userChoice.equals(computerChoice)){
            System.out.println("Oavjort!");
        }
        else{
            switch (userChoice) {
                case "sten" -> rock(computerChoice);
                case "sax" -> scissors(computerChoice);
                case "påse" -> paper(computerChoice);
                default -> System.out.println("Invalid input");
             }
        }
    }
    public static String computerChoice(){
        Random rand = new Random();
        String[] computerChoice = {"sten", "sax", "påse"};
        int randomNumber = rand.nextInt(3);
        System.out.printf("Datorn valde: %s \n", computerChoice[randomNumber]);
        return computerChoice[randomNumber];
    }
    public static void rock(String computerChoice){
        switch (computerChoice) {
            case "sax" -> System.out.println("Du vann");
            case "påse" -> System.out.println("Du förlorade");
            default -> System.out.println("Error");
        }
    }
    public static void paper(String computerChoice){
        switch (computerChoice) {
            case "sten" -> System.out.println("Du vann");
            case "sax" -> System.out.println("Du förlorade");
            default -> System.out.println("Error");
        }
    }
    public static void scissors(String computerChoice){
        switch (computerChoice) {
            case "påse" -> System.out.println("Du vann");
            case "sten" -> System.out.println("Du förlorade");
            default -> System.out.println("Error");
        }
    }

}

