package se.iths.java21.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Uppochner {

    public void uppOchNer() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        String uppOchNerOrd;
        do {
            uppOchNerOrd = sc.next();
            arrayList.add(uppOchNerOrd);
        } while (!arrayList.contains("END"));

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
