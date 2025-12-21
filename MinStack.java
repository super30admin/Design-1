// Time Complexity : O(1) for all operations
// Space Complexity : O(N) in worst case, if inputs are sorted in descending order. The minstack will hold N values.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class MinStack {
    //Keep 2 stacks, one to keep all values
    Stack<Integer> stack = new Stack<>();
    //In other one, push new value if it smaller than the current top value in the stack
    Stack<Integer> minValues = new Stack<>();

    MinStack() {
    }

    void push(int val) {
        stack.push(val);
        if (minValues.isEmpty() || minValues.peek() >= val) {
            minValues.push(val);
        }
    }

    void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty");
        }

        if (stack.peek().equals(minValues.peek())) {
            stack.pop();
            minValues.pop();
        } else {
            stack.pop();
        }
    }

    int top() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack.peek();
    }

    int getMin() {
        if (stack.isEmpty() || minValues.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return minValues.peek();
    }
}
