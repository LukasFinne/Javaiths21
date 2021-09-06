package se.iths.java21.Exercises.Methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Nine {

    public static void main(String[] args) {

        daysBetween("2000-02-01", "2000-03-01");
    }

    public static void daysBetween(String d1, String d2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        try{
            Date firstDate = sdf.parse(d1);
            Date secondDate = sdf.parse(d2);
            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            System.out.println ("Days: " + diffInDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
