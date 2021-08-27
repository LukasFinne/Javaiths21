package se.iths.java21;


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
        System.out.println("e. End");
        System.out.println("4. Return to the menu");
    }

    public static void menuSelection(){
        boolean menuFunction = true;

        while(menuFunction){
            String select = sc.next().toLowerCase();

            switch (select){
                case "1":
                    System.out.println("Du valde UppochNer snälla skriv ett viss antal strängar, Tack!");
                    uppOchNer();
                    break;
                case "2":
                    MaxAndMin();
                    break;
                case "e"://Fixa detta sen
                    System.out.println("Program ended");
                    menuFunction = false;
                    break;
                case "4":
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

    public static void MaxAndMin(){
        int[] numberArray = new int[5];

        System.out.println("Skriv fem heltal! ");
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = sc.nextInt();
        }

        Arrays.sort(numberArray);
        System.out.printf("Min value: %d \n", numberArray[0]);
        System.out.printf("Max value: %d \n \n", numberArray[4]);
        System.out.println("Finished!");
        System.out.println();
        menu();
    }

}
