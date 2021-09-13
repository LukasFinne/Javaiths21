package se.iths.java21.lab;

import java.util.Random;
import java.util.Scanner;

public class Rockpaperscissors {

    static int userWins = 0;
    static int computerWins = 0;
    static int round = 0;

    public static void rockPaperScissors() {
        userWins = 0;
        computerWins = 0;
        round = 0;

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
            System.out.printf("\nAnvändare: %d Datorn: %d \n", userWins, computerWins);
            System.out.println("\033[1mDu vann matchen!\033[0m\n");
        } else {
            System.out.printf("\nAnvändare: %d Datorn: %d \n", userWins, computerWins);
            System.out.println("\033[1mDator vann matchen!\033[0m\n");
        }

    }

    public static void result(String userChoice, String computerChoice) {

        if (userChoice.equals(computerChoice)) {
            System.out.println("\033[1mOavjort!\033[0m\n");
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
                System.out.println("\033[1mDu vann matchen!\033[0m\n");
                userWins++;
            }
            case "påse" -> {
                System.out.println("\033[1mDator vann matchen!\033[0m\n");
                computerWins++;
            }
            default -> System.out.println("Error");

        }
    }

    public static void paper(String computerChoice) {
        switch (computerChoice) {
            case "sten" -> {
                System.out.println("\033[1mDu vann matchen!\033[0m\n");
                userWins++;
            }
            case "sax" -> {
                System.out.println("\033[1mDator vann matchen!\033[0m\n");
                computerWins++;
            }
            default -> System.out.println("Error");
        }
    }

    public static void scissors(String computerChoice) {
        switch (computerChoice) {
            case "påse" -> {
                System.out.println("\033[1mDu vann matchen!\033[0m\n");
                userWins++;
            }
            case "sten" -> {
                System.out.println("\033[1mDator vann matchen!\033[0m\n");
                computerWins++;
            }
            default -> System.out.println("Error");
        }
    }

}

