package se.iths.java21.Lab;


import java.util.*;

public class Menu {

    public static void main(String[] args) {
        menu();
        menuSelection();
    }
    public static void menu(){
        System.out.println("Välj vad du vill göra!");
        System.out.println("1. Upp och ner");
        System.out.println("2. Min och Max");
        System.out.println("3. Sten, Sax, Påse");
        System.out.println("4. Ordning och reda");
        System.out.println("e. Avsluta");

    }
    public static void menuSelection(){
        Rockpaperscissors rockPaperScissors = new Rockpaperscissors();
        Maxandmin Maxandmin = new Maxandmin();
        Inorder inOrder = new Inorder();
        Uppochner Uppochner = new Uppochner();

        boolean menuFunction = true;

        Scanner sc = new Scanner(System.in);

        while(menuFunction){
            String select = sc.next().toLowerCase();

            switch (select) {
                case "1" -> {
                    System.out.println("Du valde UppochNer snälla skriv ett viss antal strängar, Tack!");
                    Uppochner.uppOchNer();
                    menu();
                }
                case "2" -> {
                    System.out.println("Skriv fem heltal! ");
                    Maxandmin.maxMin();
                    menu();
                }
                case "3" -> {
                    System.out.println("Skriv sten, sax, eller påse");
                    rockPaperScissors.rockPaperScissors();
                    menu();
                }
                case "4" -> {
                    System.out.println("Ordning och reda");
                    inOrder.inOrder();
                    menu();
                }
                case "e" -> {
                    System.out.println("Programmet avslutades");
                    menuFunction = false;
                }
                default -> {
                    System.out.println("Felaktig inmatning, försök igen.");
                    menu();
                }
            }

        }

    }

}
