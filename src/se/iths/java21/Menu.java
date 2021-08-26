package se.iths.java21;

import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        boolean menuSelection = true;

        menu();

        while(menuSelection){
        String select = sc.next();
        int selectNumber = Integer.parseInt(select);

        switch (selectNumber){
                case 1:
                    System.out.println("Du valde UppochNer snälla skriv ett viss antal strängar, Tack!");
                    System.out.println("To go back click 4!");
                    break;
                case 2:
                    System.out.println("Bye");
                    break;
                case 3:
                    System.out.println("Program ended");
                    menuSelection = false;
                    break;
                case 4:
                    System.out.println("Return to the menu");
                    menu();
                    break;
                default:
                    System.out.println("Error");
                    break;
            }

        }


    }
    public static void menu(){
        System.out.println("Please select what you want to do!");
        System.out.println("1. Tick tock");
        System.out.println("2. stensaxpåse");
        System.out.println("3. End");
        System.out.println("4. Return to the menu");
    }

    public static void menuS(){

    }

    public static void UppochNer(){



    }

}
