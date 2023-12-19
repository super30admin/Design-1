// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

// the code utilizes a stack of integer arrays to store elements and their corresponding minimum values
class Problem2 {

    private Stack<int[]> stack = new Stack<>();

    public Problem2() { }


    public void push(int x) {

        /* If the stack is empty, then the min value
         * must just be the first value we add. */
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }

        int currentMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x, currentMin)});
    }


    public void pop() {
        stack.pop();
    }


    public int top() {
        return stack.peek()[0];
    }


    public int getMin() {
        return stack.peek()[1];
    }
}