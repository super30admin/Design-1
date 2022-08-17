// Time Complexity : O(1) for all functions
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class MinStack {

    // with 1:1 mapping approach
    private Stack<Integer> st;
    private Stack<Integer> minStack;
    private Integer min;

    public MinStack() {
        this.st = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        min = Math.min(min,val);
        st.push(val);
        minStack.push(min);
    }

    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return st.peek();
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