// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;
    public MinStack() {
        this.stack = new Stack();
        this.minStack = new Stack();
        this.min = Integer.MAX_VALUE;
        this.minStack.push(min);
    }

    public void push(int val) {
        min = Math.min(min, val);
        this.stack.push(val);
        this.minStack.push(min);
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
        this.min = minStack.peek();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
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