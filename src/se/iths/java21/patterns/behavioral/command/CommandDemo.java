package se.iths.java21.patterns.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CommandDemo {

    final static Scanner sc = new Scanner(System.in);
    static int total = 0;
    static Deque<Command> deque = new ArrayDeque<>();
    public static void main(String[] args) {


        while(true){
            int choice = sc.nextInt();

            switch (choice){
                case 0 -> System.exit(0);
                case 1 -> CommandDemo.Undo();
                case 2 -> CommandDemo.DoPlus();
                case 3 -> CommandDemo.DoMinus();
                //default -> CommandDemo.Do(choice);
            }

            System.out.println("Current total: " + total);

        }
    }

    private static void DoMinus() {
        System.out.println("Enter value to substract");
        int value = sc.nextInt();
        total -= value;
        deque.addLast(() -> total+=value);
    }

    private static void DoPlus() {
        System.out.println("Enter value to add");
        int value = sc.nextInt();
        total += value;
        deque.addLast(() -> total-=value);
    }

    private static void Undo() {
        if(deque.isEmpty())
            return;
        Command command = deque.removeLast();
        command.execute();
    }
}
