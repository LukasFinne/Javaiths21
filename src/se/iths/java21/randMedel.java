package se.iths.java21;

import java.util.Random;
import java.util.Scanner;

public class randMedel {

    public static void main(String[] args) {
        double total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv hur många tal du vill ha!");
        int tal = sc.nextInt();

        int[] arr = new int[tal];
        int rand;
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            rand = r.nextInt(1000);
            arr[i] = rand;
            total += arr[i];
            System.out.println(arr[i]);
        }

        System.out.println("Medelvärde av dessa talet är: " + total/tal);

    }
}
