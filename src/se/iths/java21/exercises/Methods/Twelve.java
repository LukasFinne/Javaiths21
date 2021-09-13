package se.iths.java21.exercises.Methods;

public class Twelve {
    public static void main(String[] args) {
        System.out.println( backwards("hejsan"));
    }

    public static String backwards(String word){
        String reversed = "";
        System.out.println(word.length());
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        return reversed;
    }
}
