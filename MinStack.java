// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:

import java.util.Stack;

class MinStack {

    // Maintain 2 stacks - one for regular operations and one for storing the current min value in the stack.
    Stack<Integer> stack;
    Stack<Integer> minVal;

    public MinStack() {
        stack = new Stack<>();
        minVal = new Stack<>();
    }

    public void push(int val) {
        //  Push a value into the minVal stack only when its peek value is greater than or equal to the element pushed into the main stack
        //  This will always keep the minimum value at the top of the minVal stack
        if (minVal.isEmpty() || val <= minVal.peek())
            minVal.push(val);

        stack.push(val);

    }

    public void pop() {
        //  To maintain consistency,we pop from the minVal stack only when we are removing the actual minimum value in the main stack
        if (stack.peek().equals(minVal.peek()))
            minVal.pop();

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVal.peek();
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