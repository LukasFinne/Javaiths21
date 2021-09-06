package se.iths.java21.Exercises.Methods;

public class Four {

    public static void main(String[] args) {
        System.out.println(function("Nice"));
    }
    public static int function(String x){

        try{
             return Integer.parseInt(x);
        }catch (Exception e){
            System.out.println("Invalid");


        }
return 0;

    }
}
