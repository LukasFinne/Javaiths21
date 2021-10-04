package se.iths.java21.advancedstreams;

import java.util.List;

public class FlatMap {
    public static void main(String[] args) {
        List<List<Integer>> nonFlat = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8));

        nonFlat.stream()
                //.peek(System.out::println)
                .flatMap(list -> list.stream())
                .forEach(System.out::println);
    }
}
