// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.Stack;

class MinStack {

    private Stack<Integer> minStack;
    private int currentMinVal;

    public MinStack() {
        this.minStack = new Stack<Integer>();
        this.currentMinVal = Integer.MAX_VALUE;

    }

    public void push(int val) {

        if(val <= currentMinVal) {
            minStack.push(currentMinVal);
            currentMinVal = val;
        }
        minStack.push(val);
    }

    public void pop() {
        if(minStack.pop() == currentMinVal) {
            currentMinVal = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }


    public int getMin() {

        return currentMinVal;
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