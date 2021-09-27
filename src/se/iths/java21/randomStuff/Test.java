package se.iths.java21.randomStuff;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String size = sc.next();


        if (areBracketsBalanced(size))
            System.out.println("b");
        else
            System.out.println("nb");

    }

    static boolean areBracketsBalanced(String size) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < size.length(); i++) {
            if (Objects.equals(size.charAt(i), '(') || Objects.equals(size.charAt(i), '{') || Objects.equals(size.charAt(i), '[')){
                stack.push(size.charAt(i));
                continue;
            }

            char check;
            switch (size.charAt(i)) {
                case ')':
                        check = stack.pop();
                    if ( check == '{' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());

    }

}
