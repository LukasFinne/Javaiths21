package se.iths.java21.ArrayDemo;

public class DynamicArray {

    int[] values = new int[10];
    int counter = 0;

    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add(1);
        dynamicArray.add(2);
        for (int value : dynamicArray.values) {
            System.out.println(value);
        }

    }

    void add(int value){
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

}
