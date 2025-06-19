// Time Complexity : push(), pop(), top(), getMin() all have O(1) time complexity.
// Space Complexity : O(n) due to the 2 stacks we maintain (2*n) actually.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Implemented minStack using two different stacks, one to maintain the value and the other for the corresponding
// minimum value at the time for achieving O(1) complexity for all operations. 
class MinStack {
    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        valueStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }
    
    public void pop() {
        valueStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return valueStack.peek();
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
