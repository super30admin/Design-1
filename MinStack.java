// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.Stack;

class MinStack {

    Stack<int[]> stack = new Stack<>();

    private static final int VAL = 0;
    private static final int MIN = 1;

    public void push(int val) {
        if(stack.isEmpty())
            stack.push(new int[]{val, val});
        else
            stack.push(new int[]{val, Math.min(val, stack.peek()[MIN])});

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[VAL];
    }

    public int getMin() {
        return stack.peek()[MIN];
    }
}
