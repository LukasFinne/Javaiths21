package se.iths.java21.Lab;

import java.util.Random;
import java.util.Scanner;

public class Rockpaperscissors {

    public static void stenSaxPåse(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv sten, sax, eller påse");
        String userChoice = sc.next().toLowerCase();
        result(userChoice,computerChoice());
    }

    public static void result(String userChoice, String computerChoice){
        if(userChoice.equals(computerChoice))
            System.out.println("Oavjort!");
        else if(userChoice.equals("sten"))
            rock(userChoice, computerChoice);
        else if(userChoice.equals("sax"))
            scissors(userChoice, computerChoice);
        else if(userChoice.equals("påse"))
            paper(userChoice, computerChoice);
    }
    public static String computerChoice(){
        Random rand = new Random();
        String[] computerChoice = {"sten", "sax", "påse"};
        int randomNumber = rand.nextInt(3);
        System.out.printf("Datorn valde: %s \n", computerChoice[randomNumber]);
        return computerChoice[randomNumber];
    }
    public static void rock(String userChoice, String computerChoice){
        if (userChoice.equals("sten") && computerChoice.equals("sax"))
            System.out.println("Du vann!");
        else if (userChoice.equals("sten") && computerChoice.equals("påse"))
            System.out.println("Du förlorade");

    }
    public static void paper(String userChoice, String computerChoice){
        if (userChoice.equals("påse") && computerChoice.equals("sten"))
            System.out.println("Du vann!");
        else if (userChoice.equals("påse") && computerChoice.equals("sax"))
            System.out.println("Du förlorade");

    }
    public static void scissors(String userChoice, String computerChoice){
        if (userChoice.equals("sax") && computerChoice.equals("påse"))
            System.out.println("Du vann!");
        else if (userChoice.equals("sax") && computerChoice.equals("sten"))
            System.out.println("Du förlorade");
    }

}
}
