// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

import java.util.Stack;

class MinStack {

    private Stack<Integer> stk;
    private Stack<Integer> minStk;
    private int min;

    public MinStack() {
        stk = new Stack<>();
        minStk = new Stack<>();
        min = Integer.MAX_VALUE;
        minStk.push(min);
    }
    
    public void push(int val) {
        stk.push(val);
        min = Math.min(min, val);
        minStk.push(min);
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
        min = minStk.peek();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
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