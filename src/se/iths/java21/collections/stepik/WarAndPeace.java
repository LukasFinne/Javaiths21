package se.iths.java21.collections.stepik;

import java.util.*;

public class WarAndPeace {

    //  a aa abC aa ac abc bcd a

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortedMap<String, Integer> map = new TreeMap<>();
        String ji = sc.nextLine().toLowerCase();
        String[] testArr = ji.split(" ");
        int counter = 1;
        for (String s : testArr) {
            counter = map.containsKey(s) ? map.get(s) : 0;
            map.put(s, counter + 1);
        }
        for (Map.Entry<String, Integer> product : map.entrySet()) {
            System.out.println(product.getKey() + " " + product.getValue());
        }
    }
}
