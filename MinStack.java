// Time Complexity for push, pop and top operations: O(1)
// Space Complexity : O(1) as we do not consider stacks used inside the constructor. So, there is no auxiliary space.
// Did this code successfully run on Leetcode :Yes

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        stack.push(val);
        min = Math.min(min, val);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
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