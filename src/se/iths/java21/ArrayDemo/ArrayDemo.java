package se.iths.java21.ArrayDemo;

import java.util.Scanner;

public class ArrayDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers do you want in the array?");
        int arrLength = sc.nextInt();
        int[] array = new int[arrLength];

        int counter = 0;
        System.out.println("Enter value: ");
        while(counter < array.length){
            array[counter++] = sc.nextInt();
        }

        for (int x : array) {
            System.out.println(x);
        }

    }
}
