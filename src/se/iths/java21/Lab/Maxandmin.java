package se.iths.java21.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Maxandmin {

    int[] unsortedArray;

    public void arraySort(int[] array) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        unsortedArray = new int[array.length];
        System.arraycopy(array, 0, unsortedArray, 0, array.length);

        bubbleSort(array);
    }

    public void bubbleSort(int[] array) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public void maxMin() {

        int[] numberArray = new int[5];

        arraySort(numberArray);

        System.out.printf("Min värde: %d \n", numberArray[0]);
        System.out.printf("Max värde: %d \n \n", numberArray[4]);
        System.out.println("Färdig!");
    }

}
