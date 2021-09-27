package se.iths.java21.exercises.generics;


import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MyDeque<T> implements Iterable<T> {
    private DNode<T> head;
    private DNode<T> tail;
    private int counter;


    public void push(T obj) {
        DNode<T> node = new DNode<>();
        node.data = obj;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        counter++;
    }

    public T pop() {
        if (head == null)
            throw new IllegalStateException();
        var temp = head.data;
        head = head.next;

        if (head != null)
            head.prev = null;
        else
            tail = null;

        counter--;
        return temp;
    }

    public T peek() {
        return head.data;
    }

    public int size() {
        return counter;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyDequeIterator();
    }

    public void forEach(Consumer<? super T> consumer) {
        var temp = head;

        while (temp != null) {
            consumer.accept(temp.data);
            temp = temp.next;
        }
    }

    public void forEachDesc(Consumer<? super T> consumer) {
        var temp = tail;

        while (temp != null) {
            consumer.accept(temp.data);
            temp = temp.prev;
        }
    }

    class MyDequeIterator implements Iterator<T>{

        private DNode<T> next = head;
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T t = next.data;
            next = next.next;
            return t;
        }
    }
    static class DNode<T> {
        T data;
        DNode<T> next;
        DNode<T> prev;
    }

}




