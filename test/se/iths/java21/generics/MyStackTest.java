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



    @Test
    void pushTwoItemsPopShouldReturnLastAddedItem() {
        myStack.push("First Item");
        myStack.push("Second Item");
        String result = myStack.pop();

        assertEquals("Second Item",result);
    }


    @Test
    void pushTwoItemsPopTwiceShouldReturnBothItemsInLIFOOrder() {
        myStack.push("First Item");
        myStack.push("Second Item");

        assertEquals("Second Item", myStack.pop());
        assertEquals("First Item", myStack.pop());
    }

}