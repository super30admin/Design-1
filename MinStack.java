// Time Complexity : O(1) for all operations search, add, remove
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.Stack;

class MinStack {

    private Stack<int[]> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (this.stack.isEmpty()) {
            this.stack.push(new int[] { val, val });
            return;
        }
        int[] pair = this.stack.peek();
        int min = pair[1];
        if (val < min) {
            this.stack.push(new int[] { val, val });
            return;
        }
        this.stack.push(new int[] { val, min });
    }

    public void pop() {
        if (!this.stack.isEmpty()) {
            this.stack.pop();
        }
    }

    public int top() {
        if (!this.stack.isEmpty()) {
            int[] peek = this.stack.peek();
            return peek[0];
        }
        return -1;
    }

    public int getMin() {
        if (!this.stack.isEmpty()) {
            return this.stack.peek()[1];
        }
        return -1;
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