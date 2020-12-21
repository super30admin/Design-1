import java.util.Stack;

class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack()
    {
        stack = new Stack();
        min = new Stack();
    }

    public void push(int x)
    {
        stack.push(x);
        if(min.isEmpty())
            min.push(x);
        else
            min.push(Math.min(min.peek(), x));
    }

    public void pop()
    {
        stack.pop();
        min.pop();
    }

    public int peek()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return min.peek();
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public boolean isFull()
    {
        return (!stack.isEmpty());
    }

    static void main(String[] args) {
    
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min1 = minStack.getMin(); 
        System.out.println(min1);
        minStack.pop();
        int top1 = minStack.peek();
        System.out.println(top1);
        int min2 = minStack.getMin();
        System.out.println(min2);
 }
}




    


