// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;

class MinStack {

    Stack stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
       return (int) stack.peek();
    }
    
    public int getMin() {
        int min = top();
        //iterate through the stack
        for(Object obj :  stack)
        {
            if(min> (int) obj)
            {
                min = (int) obj;
            }
        }

        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */