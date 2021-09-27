package se.iths.java21.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart implements Command {
    private final Scanner sc = new Scanner(System.in);
    private final Command[] commands = new Command[5];
    List<String> cart = new ArrayList<>();
    Products meat = new Meat();
    int sum;

    public Cart(){
        commands[1] = this::runMeat;
        commands[2] = () -> System.out.println("Test");
        commands[0] = Menu::new;
    }

    @Override
    public void execute() {
        runMeat();
    }

    //Not remove
   /* public void menuSelectionMeat() {
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

    }*/
    //Not remove

    private void addMeatToCart(int i) {
        if (meat.stock(i) == 0) {
            System.out.println("Not in stock");
        } else {
            cart.add(meat.getName(i));
            meat.removeStock(i);
            sum += meat.getPrice(i);
        }
        showCart();
    }

    private void showCart() {
        System.out.println("Products: ");
        cart.forEach(x -> System.out.printf("%s \n", x));
        System.out.println("Total amount:" + sum + "Kr");
    }

    private void executeChoice(int choice) {
        commands[choice].execute();
    }

    private int readChoice(Scanner sc) {
        return sc.nextInt();
    }

    private void run() {
        int choice = 0;
        do {
            //tempMenu();
            choice = readChoice(sc);
            executeChoice(choice);
        } while (choice != 0);
    }

    private void runMeat() {
        int choice = 0;
        do {
            meat();
            choice = readChoice(sc);
            executeChoice(choice);
        } while (choice != 0);
    }

    private void meat() {
        meat.setProducts();
        meat.getProducts();
        commands[1] = () -> addMeatToCart(0);
        commands[2] = () -> addMeatToCart(1);
        printMenuOption(3,4,0);

    }

    private void receipt() {
        System.out.println("Here is your receipt!");
        showCart();
        back();
    }

    private void back() {
        sum = 0;
        cart.clear();
    }

    private void printMenuOption(int cart, int receipt, int back) {
        System.out.println("3. Cart");
        System.out.println("4. Check out");
        System.out.println("0. Back");

        commands[cart] = this::showCart;
        commands[receipt] = this::receipt;
        commands[back] = Menu::new;


    }


}
