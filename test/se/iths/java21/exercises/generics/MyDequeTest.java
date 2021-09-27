package se.iths.java21.exercises.generics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyDequeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    MyDeque<Integer> integerMyDeque = new MyDeque<>();

    @BeforeEach
    void setUpOutStream(){
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreOutStream() {
        System.setOut(originalOut);
    }

    @Test
    void forEachRunsOurCodeInRightOrder() {
        integerMyDeque.push(1);
        integerMyDeque.push(2);
        integerMyDeque.push(3);
        integerMyDeque.forEach(System.out::println);
        assertEquals("3\r\n2\r\n1\r\n",outContent.toString());
    }

    @Test
    void forEachDescRunsOurCodeInRightOrder() {
        integerMyDeque.push(1);
        integerMyDeque.push(2);
        integerMyDeque.push(3);
        integerMyDeque.forEachDesc(System.out::println);
        assertEquals("1\r\n2\r\n3\r\n",outContent.toString());
    }

    @Test
    void forEachRunsOurCodeInRightOrderUsingList() {
        integerMyDeque.push(1);
        integerMyDeque.push(2);
        integerMyDeque.push(3);
        List<Integer> integers = new ArrayList<>();

        integerMyDeque.forEach(s -> integers.add(s));

        assertEquals(3,integers.get(0));
        assertEquals(2,integers.get(1));
        assertEquals(1,integers.get(2));
    }



    @Test
    void loopingMyDequeUsingIterator() {
        integerMyDeque.push(1);
        integerMyDeque.push(2);
        integerMyDeque.push(3);

        for( Integer value  : integerMyDeque) {
            System.out.println(value);
        }
        assertEquals("3\r\n2\r\n1\r\n",outContent.toString());
    }
}