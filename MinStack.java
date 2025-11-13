// Time complexity: O(1) for all operations
// Space complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Implement using single stack
import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    int minValue;
    public MinStack() {
        stack = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val <= getMin()) { // Consider the case when current min and previous min are same
            stack.push(getMin()); // push previous minimum value
            minValue = val; // update new minimum value
        }
        stack.push(val); // push the value
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        if (stack.peek() == getMin()) {
            stack.pop();
            minValue = stack.pop(); // update the new minValue
        } else {
            stack.pop();
        }
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