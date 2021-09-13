package se.iths.java21.exercises.Methods;

public class Eleven {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    public static int sum(int total){
        int result = 0;
        for (int i = 0; i <= total; i++) {
            result += i;
        }
        return result;
    }
}
