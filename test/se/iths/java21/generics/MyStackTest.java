package se.iths.java21.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    MyStack<String> myStack = new MyStack<>();

    @Test
    void pushOneItemPopShouldReturnThatItem() {
        myStack.push("First Item");
        String result = myStack.pop();

        assertEquals("First Item",result);
    }

}