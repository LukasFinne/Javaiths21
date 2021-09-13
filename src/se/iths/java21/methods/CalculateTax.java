package se.iths.java21.methods;

import java.util.Scanner;

public class CalculateTax {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Skriv hur mycket du har tjänat");
            double tax = calculateTax(sc.nextInt());
            System.out.println("Skatt: " + tax + "Kr ");
        }

        public static double calculateTax(int salary){

            if(salary > 100000)
                return salary*0.4;
            else
                return salary*0.3;

        }
}
