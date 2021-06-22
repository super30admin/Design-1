import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack; 
    int min=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<Integer>();
        
    }
    
    public void push(int val) {
       if(val<=min) // comparing min value with min and pushing min and value both to stack
       {
           stack.push(min);
           min=val;
       }
        stack.push(val);
    }
    
    public void pop() {
        int peek = stack.pop(); // removing peek element and if peek is min and again we need to pop INT MAX value from stack and keeping it min
        if(peek==min)
        {
            min=stack.pop();
        }
        
    }
    
    public int top() {
        
        return stack.peek();
        
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
