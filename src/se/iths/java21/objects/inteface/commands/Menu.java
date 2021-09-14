package se.iths.java21.objects.inteface.commands;

import java.util.Scanner;

import static java.lang.System.*;

public class Menu {
    private final Scanner scanner = new Scanner(in);
    private final Command command1;
    private final Command command2;
    private final Command command3;

    public Menu() {
        command1 = new NameCommand();
        command2 = new Command() {
            @Override
            public void execute() {//detta kallas för annyomus class i java, den här har också tillgång till Menu fält
                out.println(Math.random());
                scanner.nextInt();
            }
        };
        command3 = () -> out.println("3");//Detta används idag, Kan bara användas för vår interface bara har en metod.
        //detta funkar inte med en abstract klass
    }


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }

    private void run() {
        int choice = 0;
        do {
            printMenuOption();
            choice = readChoice(scanner);
            executeChoice(choice);
        } while (choice != 0);
    }

    private void executeChoice(int choice) {
        switch (choice) {
            case 1 -> command1.execute();

            // new NameCommand().execute();//NameCommand skapas först när man väljer den, så vi kommer skapas flera objek av samma när den väljs
            //detta kallas lazycommands
            case 2 -> out.println("2");
            case 3 -> out.println("3");
            default -> out.println("");
        }
    }

    private int readChoice(Scanner scanner) {
        return scanner.nextInt();
    }

    private void printMenuOption() {
        out.println("1. Print your name");
        out.println("2. Print a random number");
        out.println("3. Print an animal  type");
        out.println("0. Exit program");
    }
}
