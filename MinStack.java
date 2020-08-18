// Time Complexity
// push(x), pop(), top(), getMin(): O(1)

// Space Complexity
// Worst case O(2N)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private int minimum;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minimum = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= minimum) {
            stack.push(minimum);
            minimum = x;
        }
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (x == minimum) {
            minimum = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimum;
    }
}