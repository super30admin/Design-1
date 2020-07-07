import java.util.Stack;

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {

    Stack<Integer> stack,stack2;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        stack2 = new Stack<>();
        min = Integer.MAX_VALUE;
        stack2.push(min);
    }
    
    public void push(int x) {
        stack.push(x);
        if(min>x)
        {
            min = x;
        }
        stack2.push(min);
    }
    
    public void pop() {
        stack.pop();
        stack2.pop();
        min = stack2.peek();
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
        if(!stack2.isEmpty())
        {
            return min;
        }

        return -1;
        
    }
}