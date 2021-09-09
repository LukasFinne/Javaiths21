package se.iths.java21.Lab;

import java.util.Random;
import java.util.Scanner;

public class Rockpaperscissors {
    static int userWins = 0;
    static int computerWins = 0;
    static int round = 0;

    public static void rockPaperScissors() {

        do {
            System.out.printf("\033[1mRunda:\033[0m %d \nAnvändare: %d Datorn: %d \n", round += 1, userWins, computerWins);
            System.out.println("Skriv sten, sax, eller påse");
            Scanner sc = new Scanner(System.in);
            String userChoice = sc.next().toLowerCase();
            result(userChoice, computerChoice());
        } while (userWins < 3 && computerWins < 3);

        winCheck();
    }

    private static void winCheck() {
        System.out.print("--------------RESULTAT--------------");
        if (userWins > computerWins) {
            System.out.printf("\n\033[1mRound:\033[0m %d \nUser: %d Computer %d \n", round, userWins, computerWins);
            System.out.println("Du vann matchen!\n");
        } else {
            System.out.printf("\n\033[1mRound:\033[0m %d \nUser: %d Computer %d \n", round, userWins, computerWins);
            System.out.println("Dator vann matchen!\n");
        }

    }

    public static void result(String userChoice, String computerChoice) {

        if (userChoice.equals(computerChoice)) {
            System.out.println("Oavjort!");
        } else {
            switch (userChoice) {
                case "sten" -> rock(computerChoice);
                case "sax" -> scissors(computerChoice);
                case "påse" -> paper(computerChoice);
                default -> {
                    System.out.println("Felaktig inmatning, försök igen.\n");
                    inputError();
                }
            }
        }


    }

    private static void inputError() {
        String userChoice;
        System.out.println("Skriv sten, sax, eller påse");
        Scanner sc = new Scanner(System.in);
        userChoice = sc.next().toLowerCase();
        result(userChoice, computerChoice());
    }

    public static String computerChoice() {
        Random rand = new Random();
        String[] computerChoice = {"sten", "sax", "påse"};
        int randomNumber = rand.nextInt(3);
        System.out.printf("Datorn valde: %s \n", computerChoice[randomNumber]);
        return computerChoice[randomNumber];
    }

    public static void rock(String computerChoice) {
        switch (computerChoice) {
            case "sax" -> {
                System.out.println("Du vann rundan");
                userWins++;
            }
            case "påse" -> {
                System.out.println("Datorn vann rundan");
                computerWins++;
            }
            default -> System.out.println("Error");

        }
    }

    public static void paper(String computerChoice) {
        switch (computerChoice) {
            case "sten" -> {
                System.out.println("Du vann rundan");
                userWins++;
            }
            case "sax" -> {
                System.out.println("Datorn vann rundan");
                computerWins++;
            }
            default -> System.out.println("Error");
        }
    }

    public static void scissors(String computerChoice) {
        switch (computerChoice) {
            case "påse" -> {
                System.out.println("Du vann rundan");
                userWins++;
            }
            case "sten" -> {
                System.out.println("Datorn vann rundan");
                computerWins++;
            }
            default -> System.out.println("Error");
        }
    }

}

