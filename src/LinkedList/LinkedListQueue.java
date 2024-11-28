package LinkedList;

import java.util.LinkedList;

public class LinkedListQueue {
    LinkedList<Integer> queue = new LinkedList<>();

    private class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }
    int count = 0;
    Node head;
    Node tail;
    public void enqueue(int item){
        Node node = new Node(item);
        if(tail == null && head== null){
            head = tail = node;
            head.next = tail;
        }else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public int dequeue()  {
        if(count==0)
            throw new IllegalStateException();
        var value = head.value;
        var temp = head.next;
        head.next = null;
        head = temp;
        count--;
        return value;
    }

//    public int peek(){
//        if(queue.isEmpty())
//            throw new IllegalStateException();
//        return queue.getFirst();
//    }
//
    public void print(){
        var temp = head;
        for (int i = 0; i < count; i++) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }




}
