import java.util.EmptyStackException;

public class Stack {
    int[] stack = new int[5];
    int count = 0;
    public void push(int item){
        if(count < stack.length){
            stack[count++] = item;
        }else{
            updatedStackSize();
            stack[count++] = item;
        }
    }

    public int pop(){
        if(count==0){
            throw new EmptyStackException();
        }
        var value = stack[count-1];
        stack[--count] = 0;
        return value;
    }

    public int peek(){
        if(count==0){
            throw new EmptyStackException();
        }
        return stack[count-1];
    }

    public boolean isEmpty(){
        return (count == 0);
    }



    private void updatedStackSize (){
        int[] newStack = new int[stack.length+ (stack.length/2)];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public void printStack(){
        for (int item:stack)
            System.out.println(item);
    }

}
