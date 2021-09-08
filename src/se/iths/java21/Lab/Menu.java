package se.iths.java21.Lab;


import java.util.*;

public class Menu {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        menu();
        menuSelection();

    }
    public static void menu(){
        System.out.println("Please select what you want to do!");
        System.out.println("1. Tick tock");
        System.out.println("2. Min Max");
        System.out.println("3. Sten, Sax, Påse");
        System.out.println("4. In order");
        System.out.println("e. End");

    }
    public static void menuSelection(){
        Rockpaperscissors rockPaperScissors = new Rockpaperscissors();
        Maxandmin Maxandmin = new Maxandmin();
        Inorder inOrder = new Inorder();
        Uppochner Uppochner = new Uppochner();

        boolean menuFunction = true;

        while(menuFunction){
            String select = sc.next().toLowerCase();

            switch (select) {
                case "1" -> {
                    System.out.println("Du valde UppochNer snälla skriv ett viss antal strängar, Tack!");
                    Uppochner.uppOchNer();
                    menu();
                }
                case "2" -> {
                    Maxandmin.maxMin();
                    menu();
                }
                case "3" -> {
                    rockPaperScissors.rockPaperScissors();
                    menu();
                }
                case "4" -> {
                    System.out.println("In order");
                    inOrder.inOrder();
                    menu();
                }
                case "e" -> {
                    System.out.println("Program ended");
                    menuFunction = false;
                }
                default -> System.out.println("Error");
            }

        }

    }




}
