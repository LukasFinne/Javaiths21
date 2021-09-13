package se.iths.java21.arrays;

public class LinkedList {

    private int count = 0;
    private Node head;
    private Node last;

    public void add(int value){
        Node node = new Node();
        node.value = value;
        if(head == null){
            head = node;
            last = node;
        }
        else{
            last.next = node;
            node.prev = last;
            last = node;
        }
        count++;
    }

    public int removeLast(){
        if(length() == 0)
            return 0;

        int  val = last.value;
        if(last.prev != null){
            last = last.prev;
            last.next = null;
        }
        else{
            head = null;
            last = null;
        }
        count--;
        return val;
    }

    public int length(){return count;}

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(15);
        list.add(3);
        list.add(17);
        list.add(90);
        System.out.println(list.length());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
    }
}


class Node{
    int value;
    Node next;
    Node prev;
}