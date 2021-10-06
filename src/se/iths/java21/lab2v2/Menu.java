package se.iths.java21.lab2v2;

import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);
    private static final Command[] commands = new Command[5];
    Products p = new Products();

    public Menu() {
        commands[1] = new Products();
        commands[2] = this::categories;
        commands[3] = () -> p.getAllProducts().forEach(System.out::println);
        commands[4] = new Cart();
        commands[0] = this::shutdown;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }

    private void shutdown() {
        p.saveToFile();
        System.exit(0);
    }

    private void run() {
        int choice = 0;
        do {
            printMenuOption();
            choice = readChoice(sc);
            executeChoice(choice);
        } while (choice != 0);
    }

    private void executeChoice(int choice) {
        commands[choice].execute();
    }

    private int readChoice(Scanner sc) {
        return sc.nextInt();
    }

    private void categories(){
        System.out.println("These are our Categories! Please search for one of the categories to see the products!");
        for (Category c : Category.values()) {
            System.out.println(c);
        }

    }

    private void printMenuOption() {
        System.out.println("1. Search");
        System.out.println("2. Categories");
        System.out.println("3. Show all products");
        System.out.println("4. Cart");
        System.out.println("0. Exit program");
    }


}
