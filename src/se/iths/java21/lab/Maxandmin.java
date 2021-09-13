package se.iths.java21.lab;

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
        int count = 0;
        int temp;
        while (swapped) {
            swapped = false;
            count++;
            for (int i = 0; i < array.length - count; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
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
