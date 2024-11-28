import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        reverseK(queue,3);
    }
    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty())
            queue.add(stack.pop());
        System.out.println(queue.toString());
    }

    public static void reverseK(Queue<Integer> queue, int k){
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> temp = new ArrayDeque<>();
        while(k>0) {
            stack.push(queue.remove());
            k--;
        }
        while(!queue.isEmpty()){
            temp.add(queue.remove());
        }
        while(!stack.empty())
            queue.add(stack.pop());
        while(!temp.isEmpty())
            queue.add(temp.remove());

        System.out.println(queue.toString());
    }
}
