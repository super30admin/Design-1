// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

import java.util.Stack;

class MinStack {
    Stack<Integer> min;
    Stack<Integer> stack;
    public MinStack() {
        min = new Stack<Integer>();
        stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        int minval = val;
        stack.push(val);
        if (!min.isEmpty() && min.peek() < minval) {
            minval = min.peek();
        }
        min.push(minval);
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}