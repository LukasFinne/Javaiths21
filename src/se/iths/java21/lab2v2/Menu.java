package se.iths.java21.lab2v2;

import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);
    private static final Command[] commands = new Command[7];
    Products p = new Products();
    Cart c = new Cart();
    public Menu() {
        commands[1] = new Products();
        commands[2] = this::categories;
        commands[3] = () -> p.getAllProducts();
        commands[4] = () -> c.showCart();
        commands[5] = this::messageOfDay;
        commands[6] = () -> p.saveToFile();
        commands[0] = this::shutdown;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }

    private void shutdown() {
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

    private void messageOfDay() {
        System.out.println("Veckans erbjudan");
        System.out.println("Om du köper 1 produker så får du 1% av den totala summan, 2 produker 5% och över 5 produkter 10%!");
    }

    private void executeChoice(int choice) {
        commands[choice].execute();
    }

    private int readChoice(Scanner sc) {
        return sc.nextInt();
    }

    private void categories() {
        System.out.println("Dessa är våra produkter!");
        for (Category c : Category.values()) {
            System.out.println(c);
        }

    }

    private void printMenuOption() {
        System.out.println("1. Sök");
        System.out.println("2. Kategorier");
        System.out.println("3. Visa alla produkter");
        System.out.println("4. Visa varuvagnen");
        System.out.println("5. Dagens meddelande");
        System.out.println("6. Köp");
        System.out.println("0. Exit program");
    }


}
