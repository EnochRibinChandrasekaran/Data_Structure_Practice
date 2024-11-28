import java.util.Arrays;

public class PriorityQueue {
    int[] queue;

    int count;
    int pointer;
    public PriorityQueue(int capacity){
        queue =  new int[capacity];
    }


    public void enqueue(int item){
        if(count == queue.length)
            throw new IllegalStateException();
        if(count == 0){
            queue[0] = item;
        }else{
            for (int i = count-1; i >= 0; i--) {
                if(queue[i] > item){
                    queue[i+1] = queue[i];
                }else {
                    queue[i+1] = item;
                    break;
                }
            }
        }
        count++;
    }

    public int dequeue(){
        if(count == 0)
            throw new IllegalStateException();
        var temp = new int[queue.length];
        var value = queue[0];
        for (int i = 1; i <= count-1; i++) {
            temp[i-1] = queue[i];
        }
        queue = temp;
        return value;
    }

    public String toString(){
        return Arrays.toString(queue);
    }
}
