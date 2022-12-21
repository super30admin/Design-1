// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/*
    Using One to One mapping of current value and minimum value
    minValue variable kept track of mminimum value from minStack
 */
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int minValue;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minValue = Integer.MAX_VALUE;
        minStack.push(minValue);
    }

    public void push(int x) {
        stack.push(x);
        minValue = Math.min(x, minValue);
        minStack.push(minValue);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
        minValue = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
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