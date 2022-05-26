/*Time Complexity for push, pop and top operations: O(1)
 *Space Complexity : O(1) as we do not consider stacks used inside the constructor. So, there is no auxiliary space.
 *Did this code successfully run on Leetcode :Yes
 */

import java.util.*;

class MinStack {
 
    private Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val<=min) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }

    public void pop() {
        if (min == minStack.pop()) {
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
