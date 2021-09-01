package se.iths.java21;



import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 20; i > 0; i--) {
            if(i%2 == 0){
                System.out.println(i);
            }
        }





        int a = 3;
        if( a > 1 )
            System.out.println("a > 1 (första)");
        a--;
        if( a > 1 ) {
            System.out.println("a > 1 (andra)");
        }
        else {
            System.out.println("a <= 1");
        }

        for (int i = 0; i < 17; i++) {
            System.out.println(i);
        }



        System.out.println("Skriv ditt saldo! ");
        int saldo = sc.nextInt();
        System.out.println("Skriv räntesatsen");
        double ränta = sc.nextDouble();
        double sum = saldo*ränta;
        System.out.println("Det här är ditt saldo efter ränta");
        System.out.println(sum);




    }

    public static long fact(long n){
        if(n == 0)
            return 1;

        return n*fact(n -1);
    }
}
