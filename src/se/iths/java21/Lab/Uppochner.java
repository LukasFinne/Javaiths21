package se.iths.java21.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Uppochner {//Change name

    public void uppOchNer() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        String uppOchNerOrd;
        do { //add another method?
            uppOchNerOrd = sc.next();
            arrayList.add(uppOchNerOrd);
        } while (!arrayList.contains("END"));

        reverse(arrayList, uppOchNerOrd);
    }

    private void reverse(ArrayList<String> arrayList, String uppOchNerOrd) {//maybe can remove the if statment
        if (uppOchNerOrd.contains("END")) {
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
}
