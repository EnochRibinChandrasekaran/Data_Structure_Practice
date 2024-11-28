import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {
    Stack<Integer> minStack = new Stack<>();

    public void push(int item){
        if(minStack.isEmpty()){
            minStack.push(item);
        }else if(item < minStack.peek()){
        minStack.push(item);
        }
    }

    public void pop(){
        if(minStack.isEmpty())
            throw new EmptyStackException();
        minStack.pop();
    }

    public int minValue(){
        return minStack.peek();
    }
    @Override
    public String toString(){
        return Arrays.toString(minStack.toArray());
    }
}
