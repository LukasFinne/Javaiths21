package se.iths.java21.lab2;

import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final Command[] commands = new Command[4];

    public Menu(){
        commands[1] = () -> System.out.println("Moose");
        commands[2] =  new Category();
        commands[3] = () -> System.out.println("Moose");
        commands[0] = this::shutdown;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }

    public void shutdown(){
        System.exit(0);
    }

    private void run(){
        int choice = 0;
        do{
            printMenuOption();
            choice = readChoice(sc);
            executeChoice(choice);
        }while(choice != 0);
    }

    private void executeChoice(int choice) {
        commands[choice].execute();
    }

    private int readChoice(Scanner sc){
        return sc.nextInt();
    }

    private void printMenuOption(){
        System.out.println("1. Search");
        System.out.println("2. Categories");
        System.out.println("3. Cart");
        System.out.println("4. Check out");
        System.out.println("0. Exit program");
    }


}
