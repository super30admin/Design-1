// Time Complexity : O(1) for push, pop, top, and getMin
// Space Complexity : O(n) due to stack storage (extra space used to store previous minimums)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Approach:
// Use a single stack but store previous minimum values whenever the current minimum changes or remains same.
// When pushing a new minimum, first push the old minimum, then update min and push the new value.
// During pop, if the popped value is equal to current min, pop again to restore the previous minimum.

class MinStack {
    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        // If new value is less than or equal to current min,
        // store the old min before updating
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        // If popped value is the current minimum,
        // restore the previous minimum from stack
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}