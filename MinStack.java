import java.util.Stack;

// Time Complexity :
// push() - O(1)
// pop() - O(1)
// top() - O(1)
// getMin() - O(1)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    // pushing the values in stack
    public void push(int val) {
        // if the val is less than current min then pushing the min to stack and updating min
        if(val <= min) {
            stack.push(min);
            min = val;
        }
        // pushing given val in stack
        stack.push(val);
    }
    
    // popping the top value from stack
    public void pop() {
        // if the popped value is equal to min, then updating the min with previous min value
        if(min == stack.pop())
            min = stack.pop();
        
    }
    
    // returning the top element
    public int top() {
        return stack.peek();
    }
    
    // returning the min value
    public int getMin() {
        return min;
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