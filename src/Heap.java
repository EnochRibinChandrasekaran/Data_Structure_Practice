import java.util.Arrays;

public class Heap {
private int [] heap = new int[20];
private int count;
public void insert(int item){
    heap[count] = item;
    insertItem(count);
    count++;
}

public int remove(){
    int oldRoot = heap[0];
    heap[0] = heap[count-1];
    heap[--count] = 0;
    //larger child index
    // larger child returns index of right or left child which is larger
    //while loop with validParent as condition
    //validParent checks if the parent is greater than its children
    for (int i = 0; i<count -1; ) {
        int left = getLeftChildIndex(i);
        int right = getRightChildIndex(i);
        if(heap[i] > heap[left] && heap[i] > heap[right])
            break;

        if(heap[i] < heap[left]){
            swapIndex(i,left);
            i = left;
        }
        if(heap[i] < heap[right]){
            swapIndex(i,right);
            i=right;
        }
    }
    return oldRoot;
}



    public boolean checkMaxHeap(){
        for (int i =count/2 -1; i >= 0; i--)
            if(!checkElementsWithChildrens(i))
                return false;
        return true;
    }

    private boolean checkElementsWithChildrens(int index) {
        if(getLeftChildIndex(index) < heap.length && getLeftChildIndex(index) >= 0)
            if(heap[getLeftChildIndex(index)] > heap[index]) return false;
        if(getRightChildIndex(index) < heap.length && getRightChildIndex(index) >= 0)
            if(heap[getRightChildIndex(index)] > heap[index]) return false;
        return true;
    }


    private void insertItem(int index){
        while (index > 0 && heap[index] > heap[getParentIndex(index)]){
            swapIndex(index,getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void swapIndex(int index, int parentIndex) {
        int parentValue = heap[parentIndex];
        heap[parentIndex] = heap[index];
        heap[index] = parentValue;
    }



    private int getLeftChildIndex(int index){
    return (index * 2) + 1;
    }
    private int getRightChildIndex(int index){
        return (index * 2) + 2;
    }

    private int getParentIndex(int index){
    return (index-1)/2;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
