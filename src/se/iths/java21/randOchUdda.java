package se.iths.java21;

import java.util.ArrayList;
import java.util.Random;

public class randOchUdda {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        Random r = new Random();
        int result = 0;
        int test = 0;
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            list.add(r.nextInt(1000));
        }
        for (int x : list) {
            System.out.println(x);
        }
        System.out.println("Det största nummret är: ");


        for (int y = 0; y < 5; y++) {
            for (int i = 0; i < 5; i++) {
                test = Math.max(list.get(i), list.get(y));
                if( test > result){
                    result = list.get(i);
                }
            }
        }
        System.out.println(result);

        for (int x : list) {
            if(x%2 > 0){
                counter++;
            }
        }
        System.out.println("Det finns " + counter +" Udda tal");


    }
}
