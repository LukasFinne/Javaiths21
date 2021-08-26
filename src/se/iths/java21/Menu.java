package se.iths.java21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        menu();
        menuSelection();

    }
    public static void menu(){
        System.out.println("Please select what you want to do!");
        System.out.println("1. Tick tock");
        System.out.println("2. stensaxpåse");
        System.out.println("3. End");
        System.out.println("4. Return to the menu");
    }

    public static void menuSelection(){
        boolean menuDisplay = true;

        while(menuDisplay){
            String select = sc.next();
            int selectNumber = Integer.parseInt(select);

            switch (selectNumber){
                case 1:
                    System.out.println("Du valde UppochNer snälla skriv ett viss antal strängar, Tack!");
                    uppOchNer();
                    break;
                case 2:
                    System.out.println("Bye");
                    break;
                case 3:
                    System.out.println("Program ended");
                    menuDisplay = false;
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

    public static void uppOchNer(){
        System.out.println();
        ArrayList<String> arr = new ArrayList<>();
        String uppOchNerOrd;
        do{
             uppOchNerOrd = sc.next();
            arr.add(uppOchNerOrd);
        }while(!arr.contains("END"));

        if(uppOchNerOrd.contains("END")){
            for (String x : arr) {
                System.out.println(x);
            }
            Collections.reverse(arr);
            arr.remove("END");
            for (String x : arr) {
                System.out.println(x);
            }
            System.out.println();
            System.out.println("Finished! Going back to the menu!");
            System.out.println();
            menu();

        }


    }

}
