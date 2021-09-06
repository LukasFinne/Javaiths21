package se.iths.java21.Exercises.Methods;

public class Ten {

    public static void main(String[] args) {
        System.out.printf("%.1f\u00B0C", converter(98.1));
    }


    public static double converter(double fahrenheit){
        return (fahrenheit-32)*5/9;
    }

}
