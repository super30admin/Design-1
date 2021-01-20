import java.util.*;

class MinStack {

    /** initialize your data structure here. */
    //Time Complexity O(1);
    // Space O(1);
    Stack<Integer> stack;
    int Min;
    public MinStack() {
        stack = new Stack<Integer>();
        Min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(Min >= x)
        {
            stack.push(Min);
            Min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(Min == stack.peek())
        {
            stack.pop();
            Min = stack.pop();
        }
        else
        {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return Min;
    }

    public static void main(String[] args)
    {
        MinStack stack = new MinStack();
        stack.push(2);stack.push(5);stack.push(6);stack.push(1);stack.push(-5);
        System.out.println("Min is "+stack.getMin());
        stack.pop();
        System.out.println("Min is "+stack.getMin());
        stack.pop();
        System.out.println("Min is "+stack.getMin());
    }
}