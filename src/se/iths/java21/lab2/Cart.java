package se.iths.java21.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart implements Command {
    Scanner sc = new Scanner(System.in);
    List<String> cart = new ArrayList<>();
    Products meatProducts = new Meat();
    private int sum;
    boolean run = true;

    @Override
    public void execute() {
        meatProducts.setProducts();
        menuSelectionMeat();
    }

    public void menuSelectionMeat() {

        while (run) {
            printMenuOption();//Compostion?, or maybe other thing?
            switch (sc.next()) {
                case "1" -> {
                    System.out.println("You have now added cow to your Cart");
                    addMeatToCart(0);
                }
                case "2" -> {
                    System.out.println("You have now added cow to your Cart");
                    addMeatToCart(1);
                }
                case "c" -> {
                    showCart();
                }
                case "e" ->{
                    receipt();
                }
                case "0" -> {
                    run = false;
                }
                default -> {
                    System.out.println("Please try again");
                    menuSelectionMeat();
                }
            }
        }

    }

    private void addMeatToCart(int i) {
        if (meatProducts.stock(i) == 0) {
            System.out.println("Not in stock");
        } else {
            cart.add(meatProducts.getName(i));
            meatProducts.removeStock(i);
            sum += meatProducts.getPrice(i);
        }
    }

    private void showCart() {
        System.out.println("Cart: ");
        cart.forEach(x -> System.out.printf("1.%s", x));
        System.out.println("Total amount:" + sum + "Kr");
    }

    private void receipt(){
        System.out.println("Here is your receipt!");
        cart.forEach(x -> System.out.printf("1.%s", x));
        System.out.println("Total amount:" + sum + "Kr");
        sum = 0;
        cart.clear();
        run = false;
    }

    private void printMenuOption() {
        System.out.println("Please select what you want to add to the cart!");
        meatProducts.getProducts();
        System.out.println("c. Cart");
        System.out.println("e. Check out");
        System.out.println("0. Back");
    }


}
