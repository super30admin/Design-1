// Time Complexity : O(1) for all operations (push, pop, top, getMin)
// Space Complexity : O(n) where n is the number of elements in the stack

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No issues faced

import java.util.Stack;

public class MinStack {
    Stack<Integer> st; // Main stack to store elements
    Stack<Integer> minSt; // Stack to track minimum elements
    int min; // Variable to hold current minimum value

    // Constructor to initialize stacks and set initial minimum value
    public MinStack() {
        this.min = Integer.MAX_VALUE; // Initialize min to maximum integer value
        this.st = new Stack<>(); // Initialize main stack
        this.minSt = new Stack<>(); // Initialize minimum stack
        this.minSt.push(min); // Push initial minimum value to minSt
    }
    
    // Method to push element to stack
    public void push(int val) {
        // Update minimum value
        min = Math.min(min, val);
        // Push updated minimum value to minSt
        this.minSt.push(min);
        // Push value to main stack
        this.st.push(val);
    }
    
    // Method to pop element from stack
    public void pop() {
        // Pop element from both stacks
        this.st.pop();
        this.minSt.pop();
        // Update min to current minimum value
        min = minSt.peek();
    }
    
    // Method to get top element from stack
    public int top() {
        return this.st.peek();
    }
    
    // Method to get minimum element from stack
    public int getMin() {
        return this.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(val);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */
