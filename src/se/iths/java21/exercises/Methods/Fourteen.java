package se.iths.java21.exercises.Methods;

public class Fourteen {
    public static void main(String[] args) {

        System.out.printf("%.1f",average(2,3,5));
    }

    public static double average(double x, double y){
        return (x+y)/2;
    }
    public static double average(double x, double y, double c){
        return (x+y+c)/3;
    }
    public static double average(double x, double y, double c, double v){
        return (x+y+c+v)/4;
    }
    public static double average(double x, double y, double c, double v, double b){
        return (x+y+c+v+b)/5;
    }
    public static double average(double x, double y, double c, double v, double b, double n){
        return (x+y+c+v+b+n)/6;
    }

}
