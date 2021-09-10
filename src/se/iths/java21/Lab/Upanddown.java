package se.iths.java21.Lab;

import java.util.Scanner;

public class Upanddown {
    DynamicArray dynamicArray = new DynamicArray();

    public void upAndDown() {
        addWordsToArray();
    }

    private void addWordsToArray() {

        Scanner sc = new Scanner(System.in);
        String upAndDownWords;
        if (dynamicArray.length() > 1)
            dynamicArray.clearArray();
        do {
            upAndDownWords = sc.next();
            dynamicArray.add(upAndDownWords);
            if (dynamicArray.get(dynamicArray.length() - 1).equals("END")) {
                reverseArray();
                break;
            }

        } while (true);
    }

    private void reverseArray() {

        for (int i = 0; i < dynamicArray.length(); i++) {
            System.out.println(dynamicArray.get(i));
        }
        dynamicArray.removeLast(dynamicArray.array());
        dynamicArray.reverseOrder();
        System.out.println("Färdig!");

    }
}
