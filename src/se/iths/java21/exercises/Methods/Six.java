package se.iths.java21.exercises.Methods;

public class Six {
    public static void main(String[] args) {
        System.out.println(getDays(Month.May));

    }

    public static int getDays(Month month){
        int days = 0;
        days = month.day;
        return days;

    }


}
