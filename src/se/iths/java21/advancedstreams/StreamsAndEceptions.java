package se.iths.java21.advancedstreams;

import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class StreamsAndEceptions {


    public static void main(String[] args) {
        var stream = Stream.of("1", "2", "3", "4", "5", "6", "a", "b", "c");
        long i = stream.mapToInt(StreamsAndEceptions::Wrapper)
                .sum();
        System.out.println(i);
    }

    private static int Wrapper(String s) {
        try {
            return parser(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static Integer parser(String s) throws Exception {//En exception måste man man ta hand om, men om vi skriver RunTimeException så behöver man inte ta hand om den
        return Integer.parseInt(s);
    }
}
