package se.iths.java21.Exercises.Methods;

public class Seven {
    public static void main(String[] args) {
        System.out.println( test("Lukas!"));
    }

    public static String test(String s){
        return s.substring(0, 3);
    }
}
