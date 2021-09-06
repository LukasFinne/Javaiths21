package se.iths.java21.Exercises.Methods;

public class two_A {
    public static void main(String[] args) {

        System.out.println(add(5,4,2,9,4,5,6,2));
    }

    public static int add(int ...x){
        int result = 1;
        for(int numbers : x ){
            result*=numbers;
        }
            return result;
    }
}
