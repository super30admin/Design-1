// Time Complexity for all operations: O(1)
// Space Complexity: O(n), where n is the number of elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Constructor to initialize stacks
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push value onto stack and update minStack
    public void push(int val) {
        stack.push(val);
        // Push to minStack if it's empty or val is <= current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop value from stack and update minStack
    public void pop() {
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get top element of main stack
    public int top() {
        return stack.peek();
    }

    // Get current minimum element in constant time
    public int getMin() {
        return minStack.peek();
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