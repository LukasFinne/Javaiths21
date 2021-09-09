package se.iths.java21.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Upanddown {

    public void upAndDown() {
        ArrayList<String> arrayList = new ArrayList<>();
        addWordsToArray(arrayList);
        reverseArray(arrayList);
    }

    private void addWordsToArray(ArrayList<String> arrayList) {
        Scanner sc = new Scanner(System.in);
        String upAndDownWords;
        do {
            upAndDownWords = sc.next();
            arrayList.add(upAndDownWords);
        } while (!arrayList.contains("END"));
    }

    private void reverseArray(ArrayList<String> arrayList) {
        for (String x : arrayList) {
            System.out.println(x);
        }
        Collections.reverse(arrayList);
        arrayList.remove("END");
        for (String x : arrayList) {
            System.out.println(x);
        }
        System.out.println("Färdig!");
    }
}
