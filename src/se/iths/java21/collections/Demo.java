package se.iths.java21.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("First");//Lägger till värdet sist av listan O(n)
        stringList.add("Second");
        //Find by index O(1)
        stringList.get(1);
        //add(index, what to add); O(n)
        stringList.add(0, "Zero");
        //Remove, use index to remove a value O(n)
        stringList.remove(0);
        //To remove the last index O(1)
        stringList.remove(stringList.size());
        //Search O(n)
        stringList.indexOf("First");

        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(6);
        integerList.add(6);
        integerList.add(6);
        integerList.add(4);
        integerList.add(4);
        integerList.add(9);

        integerList.forEach(System.out::println);
        var set = Set.copyOf(integerList);
        set.forEach(System.out::println);

        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(10);
        integers.add(4);
      //  integers.forEach(System.out::println);
        integers.add(5);
        integers.forEach(System.out::println);





    }
}
