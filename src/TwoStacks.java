public class TwoStacks {
    int[] stack = new int[10];

    int top1 =0;
    int top2 =stack.length -1;

    public void push1(int item){
        stack[top1] = item;
        top1++;
    }

    public void push2(int item){
        stack[top2] = item;
        top2--;
    }

    public int pop1(){
        return stack[--top1];
    }

    public int pop2(){
        return stack[++top2];
    }

    public boolean isEmpty1(){
        return (top1 ==0);
    }

    public boolean isEmpty2(){
        return (top2== stack.length-1);
    }

    public boolean isFull1(){
        return (top2-top1-1 == 0);
    }

    public boolean isFull2(){
        return (top2-top1-1 == 0);
    }
}
