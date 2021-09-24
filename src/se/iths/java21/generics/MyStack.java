package se.iths.java21.generics;

public class MyStack<T> {
    private Node<T> top;

    public void push(T obj){

    }

    public T pop(){
        return null;
    }

    public T peek(){
        return null;
    }


}

class Node<T>{
    T value;
    Node<T> next;

}