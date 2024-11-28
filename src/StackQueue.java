import java.util.Stack;

public class StackQueue {
    Stack<Integer> orderedStack = new Stack<>();
    Stack<Integer> reversedStack = new Stack<>();
    int count = 0;
    public void enqueue(int item){
        orderedStack.push(item);
    }

    public int dequeue(){
        if(orderedStack.isEmpty() && reversedStack.isEmpty())
            throw new IllegalStateException();

        if(reversedStack.isEmpty())
             while(!orderedStack.isEmpty())
                 reversedStack.push(orderedStack.pop());

        return reversedStack.pop();
    }

    public boolean isEmpty(){
        return orderedStack.isEmpty() && reversedStack.isEmpty();
    }

    public String toString(){
        return ("Stack 1 : " + orderedStack.toString()+"Stack 2:"+ reversedStack.toString());
    }
}
