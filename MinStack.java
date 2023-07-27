import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack()
    {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val)
    {
        stack.push(val);
        if ( minStack.isEmpty() || val <= minStack.peek())
        {
            minStack.push(val);
        }
    }
    
    public void pop()
    {
        if(!stack.isEmpty())
        {
            int val = stack.pop();
            if( val == minStack.peek())
            {
                minStack.pop();     
            }
        }
    }

    public int top()
    {
        if(!stack.isEmpty())
        {
            return stack.peek();
        }
        throw new IllegalStateException("Stack is empty.");
    }

    public int getMin()
    {
        if(!stack.isEmpty())
        {
        return minStack.peek();
        }
        throw new IllegalStateException("Stack is empty.");
    }

    public static void main(String[] args) 
    {
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(1);

        System.out.println("Current Minimum : " + s.getMin());
        s.pop();
        System.out.println("Current Minimum : " + s.getMin());

    }

}
