package se.iths.java21.Lab;

import java.util.Arrays;

public class Inorder extends Maxandmin{

    public static void inOrder(){

        int sum = 0;
        int[] numberArray = new int[5];

        arraySort(numberArray);

        for (int j : numberArray) {
            sum += j;
        }

        System.out.printf("Min value: %d \n",numberArray[0]);
        System.out.printf("2Min value: %d \n",numberArray[1]);
        System.out.printf("Max value: %d \n",numberArray[4]);
        System.out.printf("2Max value: %d \n",numberArray[3]);
        if(Arrays.equals(numberArray, unsortedArray))
            System.out.println("I ordning: true");
        else
            System.out.println("I ordning: false");
        System.out.printf("Summa: %d \n", sum);
        System.out.println("Finished! \n");
    }
}
