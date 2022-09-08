// Time Complexity :O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach


import java.util.Stack;

public class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minimumStack;

    public MinStack() {
        mainStack= new Stack<>();
        minimumStack= new Stack<>();
        minimumStack.push(Integer.MAX_VALUE);
        
    }
    
    public void push(int val) {
       
        mainStack.push(val);
        minimumStack.push(Math.min(minimumStack.peek(), val));

    }
    
    public void pop() {
        mainStack.pop();
        minimumStack.pop();
        
    }
    
    public int top() {
       return mainStack.peek();
        
    }
    
    public int getMin() {
       return minimumStack.peek();
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