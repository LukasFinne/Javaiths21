package se.iths.java21.methods;

public class Fizzbuz {


    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            printFizzBuzzForValue(i);
        }


        //Ett annat sätt att göra det med en switch eller en enchanced switch. Enhanced switch är nog den bästa alternativet
        for (int i = 0; i < 101; i++) {
            printFizzBuzzSwitch(i);
        }




    }
    //Med clean code tänkesätt ska man lägga in det i en metod, istället för void kan man använda String för att gör den mer generell
    private static String printFizzBuzzSwitch(int i) {
        return switch (i % 15) {
            case 0 -> "Fizz Buzz";
            case 3, 6, 9, 12 -> "Fizz";
            case 5, 10 -> "Buzz";
            default -> Integer.toString(i); //Eller "" + i; funkar också ett litet trix
        };
    }

    private static void printFizzBuzzForValue(int i) {
        if(i %3 == 0 && i %5 == 0){
            System.out.print("Fizz Buzz");
        } else if(i %3 == 0){
            System.out.print("Fizz");
        } else if(i %5 == 0){
            System.out.print("Buzz");
        } else
            System.out.print(i);
        System.out.print(",");
    }
}
