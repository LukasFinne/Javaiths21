package se.iths.java21;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Tasks {
/*
*/
    public static void main(String[] args) {
        int task;
        int load;
        int totalLoad1 = 0;
        int totalLoad2 = 0;
        int numberOfTasks;
        Scanner sc = new Scanner(System.in);

        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        numberOfTasks = sc.nextInt();

        for (int i = 0; i < numberOfTasks; i++) {
            task = sc.nextInt();
            load = sc.nextInt();

            if (totalLoad1 > totalLoad2) {
                q2.offer(task);
                totalLoad2 += load;
            } else {
                q1.offer(task);
                totalLoad1 += load;
            }
        }
        for (Integer integer : q1) {
            System.out.printf("%d ", integer);
        }
        System.out.println();
        for (Integer integer : q2) {
            System.out.printf("%d ", integer);
        }
    }
}
