package se.iths.java21.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Maxandmin {
    static int[] unsortedArray;
    public static int[] arraySort(int[] array){
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv fem heltal! ");

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        unsortedArray = new int[array.length];

        System.arraycopy(array, 0, unsortedArray, 0, array.length);

        Arrays.sort(array);

        return array;

    }

    public static void maxMin(){

        int[] numberArray = new int[5];

        arraySort(numberArray);

        System.out.printf("Min value: %d \n",numberArray[0]);
        System.out.printf("Max value: %d \n \n",numberArray[4]);
        System.out.println("Finished! \n");
    }

}
