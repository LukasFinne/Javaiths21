package se.iths.java21.Lab;

import java.util.Arrays;

public class DynamicArray {

    private String[] values = new String[0];
    private int counter = 0;

    void add(String value) {
        if (counter == values.length)
            grow();
        values[counter] = value;
        counter = counter + 1;
    }

    public void reverseOrder() {
        for (int i = values.length - 1; i >= 0; i--) {
            System.out.println(values[i]);
        }
    }

    public void removeLast(String[] array) {
        values = array;
        String[] newArray = new String[values.length - 1];
        System.arraycopy(values, 0, newArray, 0, values.length - 1);
        values = newArray;
    }

    int length() {
        return counter;
    }

    private void grow() {
        String[] newArray = new String[values.length + 1];
        System.arraycopy(values, 0, newArray, 0, values.length);
        values = newArray;
    }


    public String get(int i) {
        return values[i];
    }

    public void clearArray() {
        counter = 0;
        Arrays.fill(values, null);
    }

    public String[] array() {
        return values;
    }
}
