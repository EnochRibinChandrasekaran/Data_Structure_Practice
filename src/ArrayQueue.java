import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayQueue {
    int[] queue;
    int front;
    int rear;
    int count;

    public ArrayQueue(int size) {
        queue = new int[size];
    }

    public void enqueue(int item) {
        if (count == queue.length) {
            throw new IllegalStateException();
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public int dequeue() {
        if (count == 0)
            throw new EmptyStackException();
        var top = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        return top;
    }

    public int peek(){
        return queue[front];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == queue.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(queue);
    }
}
