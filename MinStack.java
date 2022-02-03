// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MinStack {

    private Stack<Integer> minStack;
    private int min;
    
    public MinStack() {
        minStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val <= min) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }
    
    public void pop() {
        int popped = minStack.pop();
        if (min == popped) {
            min = minStack.pop(); 
        }
    }
    
    public int top() {
        return minStack.peek();
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