package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private static class Node {
        private int value;
        private Node next;

        private Node(int value){
            this.value = value;
        }

    }
    private Node first;
    private Node last;

    private int count;

    public void addLast(int value){
        var newItem = new Node(value);
        if(first==null){
            first = last = newItem;
        }else{
            last.next = newItem;
            last = newItem;
        }
        count++;
    }

    public void addFirst(int value){
        var item = new Node(value);
        if(first == null){
            first = last = item;
        }else{
            item.next = first;
            first = item;
        }
        count++;
    }

    public boolean contains(int value){
        var node = first;
        while(node!=null){
            if(node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int indexOf(int value){
        var node =  first;
        int index = 0;
        while(node != null){
            if(node.value == value){
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    public void removeFirst(){
        if(first == null){
            throw new NoSuchElementException();
        }
        else if(first == last){
            first = last = null;
        }else{

        var node = first.next;
        first.next = null;
        first = node;
    }
        count--;
    }

    public void removeLast(){
        if(first == null){
            throw new NoSuchElementException();
        }else if(first == last){
            first = last = null;
        }else {

            var node = first;
            while (node != null) {
                if (node.next == last) {
                    node.next = null;
                    last = node;
                }
                node = node.next;
            }
        }
        count--;
    }

    public int size(){
        return count;
    }

    public String toString(){
        StringBuilder printString = new StringBuilder("[ ");
        var node = first;
        while(node !=  null){
           printString.append(",").append(node.value);
            node = node.next;
        }
        printString.append(" ]");
        return printString.toString();
    }

    public int[] toArray(){
        var current = first;
        var list = new int[count];
        int index= 0;
        while(current != null){
            list[index++] = current.value;
            current = current.next;
        }
        return list;
    }

    public void reverse(){
        if(first!=last){
            var previous = first;
            var current = first.next;
            while(current != null){
                var next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            last = first;
            last.next = null;
            first = previous;
        }
    }
    private Node previousNode(Node node){
        var item = first;
        while (item != null){
            if(node.next == node){
                return node;
            }
            item = item.next;
        }
        return null;
    }

    public int getKthFromTheEnd(int k){
        var firstk = first;
        var lastk = first;
        if(count > k-10){
            return -1;
        }
        for (int i = 0; i < k-1; i++) {
            lastk = lastk.next;
        }
        while(lastk!=last){
            firstk= firstk.next;
            lastk  = lastk.next;
        }
        return firstk.value;
    }

    public boolean hasLoop(){
        var slow = first.next;
        var fast = slow.next;
        while(fast !=null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;

    }


    public void createWithLoop(){
        last.next = first;
    }

    public void printMiddle(){
     var slow = first.next;
     var fast = slow.next;
     while(fast != last && fast.next!= last){
         slow = slow.next;
         fast = fast.next.next;
     }
     if(fast==last ){
         System.out.println(slow.value);
     }else{
         System.out.println(slow.value + " , "+slow.next.value );
     }
    }




}
//public class Main {
//    public static void main(String[] args) {
//        var list = new LinkedList();
//        list.addLast(10);
//        list.addLast(20);
//        list.addLast(30);
//        list.addLast(40);
////        System.out.println(list.toString());
////        list.addFirst(100);
////        System.out.println(list.toString());
////        System.out.println(list.contains(30));
////        list.removeLast();
////        System.out.println(list.toString());
//
////        System.out.println(list.size());
//        list.reverse();
//        var arrayList = list.toArray();
//        System.out.println(Arrays.toString(arrayList));
////        System.out.println(list.getKthFromTheEnd(10));
////        list.createWithLoop();
//        System.out.println(list.hasLoop());
//        list.printMiddle();
//
//
//    }
//}
