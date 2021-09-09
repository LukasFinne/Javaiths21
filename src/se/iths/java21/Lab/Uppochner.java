package se.iths.java21.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Uppochner {//Change name

    public void uppOchNer() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        String upAndDownWords;
        do { //add another method?
            upAndDownWords = sc.next();
            arrayList.add(upAndDownWords);
        } while (!arrayList.contains("END"));

        reverseMethod(arrayList);
    }

    private void reverseMethod(ArrayList<String> arrayList){
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
