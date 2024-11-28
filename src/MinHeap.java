import java.util.Arrays;

public class MinHeap {
    private class Node{
        int key;
        String value;

        private Node(int key, String value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "[ "+ key + " : " + value + " ] ";
        }

    }

    Node[] heap = new Node[10];

    int count = 0 ;
    public void add(String value, int priority){
        if(count == heap.length) {
            throw new IllegalArgumentException();
        }
        heap[count] = new Node(priority, value);
        if(!(count == 0))
            arrangeHeap();
        count++;
    }

    public Node remove(){
        Node removed = heap[0];
        heap[0] = heap[count-1];
        heap[--count] = null;
        arrangeHeap();
        return removed;
    }

    public boolean isEmpty(){
        return count == 0;
    }


    private void arrangeHeap(){
        for (int i = 0; i < count; i++) {
            int smallIndex = smallerIndex(i);
            if(smallIndex != -1){
                swap(i, smallIndex);
            }
        }
    }

    private void swap(int index1, int index2){
        Node temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    private int smallerIndex(int index){

        int left = getLeftIndex(index);
        int right = getRightIndex(index);
        if(left <= count && heap[left] !=null && heap[left].key < heap[index].key)
            return left;
        if(right <= count &&heap[right] !=null&& heap[right].key < heap[index].key)
            return right;
        return -1;
    }

    private int getLeftIndex(int index){
        return index * 2 + 1;
    }
    private int getRightIndex(int index){
        return index * 2 + 2;
    }


}
