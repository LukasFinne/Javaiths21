package se.iths.java21.threads;

import java.util.Arrays;

public class StreamArrayProcessing {
    private int[] numbers = {1,2,3,4,5,6,7,8,9,10};
    public static void main(String[] args) {

        StreamArrayProcessing streamArrayProcessing = new StreamArrayProcessing();

        streamArrayProcessing.numbers = Arrays.stream(streamArrayProcessing.numbers)
                .parallel()
                .peek(t -> System.out.println(Thread.currentThread().getName()))
                .map(i -> i *2)
                .toArray();

        Arrays.stream(streamArrayProcessing.numbers).forEach(System.out::println);

    }

}
