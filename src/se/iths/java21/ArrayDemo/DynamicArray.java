package se.iths.java21.ArrayDemo;

import java.util.Arrays;

public class DynamicArray {

    private int[] values = new int[10];
    private int counter = 0;

    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        for (int value : dynamicArray.values) {
            System.out.println(value);
        }
    }

    void add(int value){
        if(counter >= values.length )
            grow();
        values[counter] = value;
        counter = counter + 1;
    }

    int removeLast(){//Börja skriva ett test först sen själva koden, TDD = test driven development
        if(counter == 0)
            return 0;
        return values[--counter];
    }

    int length(){
        return counter;
    }
    private void grow(){
        int[] newArray = new int[values.length*2];
        System.arraycopy(values, 0, newArray, 0, values.length);
        //Sätt values att peka på nya arrayen.
        values = newArray;
    }


    public int get(int i) {
        return values[i];
    }

    public int[] get() {
        return values;
    }

}
