package se.iths.java21.lab;

import java.util.Arrays;

public class Inorder {

    public void inOrder() {
        Maxandmin maxAndMin = new Maxandmin();

        int sum = 0;
        int[] numberArray = new int[5];

        maxAndMin.arraySort(numberArray);

        for (int j : numberArray)
            sum += j;

        printArrayResult(Arrays.equals(numberArray, maxAndMin.unsortedArray), sum, numberArray);
    }

    private void printArrayResult(boolean equals, int sum, int[] numberArray) {
        System.out.printf("Min värde: %d \n", numberArray[0]);
        System.out.printf("2Min värde: %d \n", numberArray[1]);
        System.out.printf("Max värde: %d \n", numberArray[4]);
        System.out.printf("2Max värde: %d \n", numberArray[3]);
        if (equals)
            System.out.println("I ordning: true");
        else
            System.out.println("I ordning: false");
        System.out.printf("Summa: %d \n", sum);
        System.out.println("Färdig!");
    }


}
