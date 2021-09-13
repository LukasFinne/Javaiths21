package se.iths.java21.exercises.Methods;

public class Thirteen {
    public static void main(String[] args) {
        System.out.println(prime(3));
    }

    public static boolean prime(int x){
        int y = x;
        if (x / y == 1 && x/1 == x)
            return true;
        else
            return false;

    }
}
