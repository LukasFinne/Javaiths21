package se.iths.java21.Exercises.Methods;

import java.time.MonthDay;

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
