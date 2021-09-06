package se.iths.java21;

import java.util.Random;
import java.util.Scanner;

public class randMedel {

    public static void main(String[] args) {
        double total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv hur många tal du vill ha!");
        int tal = sc.nextInt();

        int[] numberArray = new int[tal];
        int randomNumbers;
        Random random = new Random();

        for (int i = 0; i < numberArray.length; i++) {
            randomNumbers = random.nextInt();
            numberArray[i] = randomNumbers;
            total += numberArray[i];
            System.out.println(numberArray[i]);
        }

        System.out.println("Medelvärde av dessa talet är: " + total/tal);

    }
}
