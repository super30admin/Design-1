// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// Using 2 stacks, 1 for storing elements. Other for storing min values up until that point
// When popping, if it is equal to the minStack's first element. Pop that as well.

class MinStack {

    Stack<Integer> stack;
    Stack<Integer>  minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        stack.push(val);
    }

    public void pop() {
        int poppedElem = stack.pop();
        if (poppedElem == minStack.peek()) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

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