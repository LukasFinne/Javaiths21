package se.iths.java21;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deque<Character> stack = new ArrayDeque<>();


        String size = sc.next();

        for (int i = 0; i < size.length(); i++) {

            if(Objects.equals(size.charAt(i), '(') || Objects.equals(size.charAt(i), '{')||Objects.equals(size.charAt(i), '['))
                stack.push(size.charAt(i));
            else if(Objects.equals(size.charAt(i), ')') || Objects.equals(size.charAt(i), '}')||Objects.equals(size.charAt(i), ']'))
                stack.pop();
        }
        System.out.println(stack);
    }
}
