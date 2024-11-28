import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    Queue<Integer> orderedQueue = new ArrayDeque<>();
    Queue<Integer> reversedQueue = new ArrayDeque<>();

    int count;

    public void push(int item){
        orderedQueue.add(item);
        count++;
    }

    public int pop(){
        var length = orderedQueue.size();
        for (int i = 0; i < length-1 ; i++) {
            reversedQueue.add(orderedQueue.remove());
        }
        count--;
        return orderedQueue.remove();
    }

    public void print(){
        System.out.println("Queue 1 : "+orderedQueue.toString()+ " Queueu 2: "+ reversedQueue.toString());
    }
}
