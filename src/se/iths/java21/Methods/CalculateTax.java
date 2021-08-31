package se.iths.java21.Methods;

import java.util.Scanner;

public class CalculateTax {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            double skatt = calculateTax(sc.nextInt());
            System.out.println("Skatt: " + skatt );
        }

        public static double calculateTax(int salary){

            if(salary > 100000)
                return salary*0.4;
            else
                return salary*0.3;

        }
}
