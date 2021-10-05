package se.iths.java21.threads;

import java.util.Scanner;

public class PrintAndRead {
    public static void main(String[] args) {
        Thread thread = new Thread(PrintAndRead::printStuff);
        thread.start();

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println("Finally " + text);
    }

    public static void printStuff(){
        while(true){
            System.out.println("Write something!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
