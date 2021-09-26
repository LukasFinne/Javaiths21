package se.iths.java21.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart extends Menu implements Command {
    Scanner sc = new Scanner(System.in);
    List<String> cart = new ArrayList<>();
     int sum;

    @Override
    public void execute() {
        menuSelectionMeat();
    }

    public void menuSelectionMeat() {
        boolean run = true;
        while (run) {
            printMenuOption();//Compostion?, or maybe other thing?
            switch (sc.next()) {
                case "meat" -> {
                    System.out.println("You have now added cow to your Cart");
                        new Meat();
                }
                case "2" -> {
                    System.out.println("You have now added cow to your Cart");
                    sc.close();
                }
                case "c" -> {
                    showCart();
                }
                case "e" ->{
                    receipt();
                    run = false;
                }
                case "0" -> {
                    back();
                    run = false;
                }
                default -> {
                    System.out.println("Please try again");
                    menuSelectionMeat();
                }
            }
        }

    }

   /*
    private void addMeatToCart(int i) {

        if (meatProducts.stock(i) == 0) {
            System.out.println("Not in stock");
        } else {
            cart.add(meatProducts.getName(i));
            meatProducts.removeStock(i);
            sum += meatProducts.getPrice(i);
        }
    } */

    private void showCart() {
        System.out.println("Products: ");
        cart.forEach(x -> System.out.printf("%s \n", x));
        System.out.println("Total amount:" + sum + "Kr");
    }

    private void receipt(){
        System.out.println("Here is your receipt!");
        showCart();
        back();
    }

    private void back(){
        sum = 0;
        cart.clear();
    }

    private void printMenuOption() {
        System.out.println("Please select what you want to add to the cart!");
        System.out.println("c. Cart");
        System.out.println("e. Check out");
        System.out.println("0. Back");
    }



}
