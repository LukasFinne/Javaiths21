package se.iths.java21.streams;

public class Guard {


    static class Against{
        public static void nullOrEmpty(String object){
            if(object == null || object.isEmpty())
                throw new IllegalArgumentException();
        }

        public static void zeroOrLess(int value) {
            if(value <= 0)
                throw new IllegalArgumentException();
        }
    }
}


