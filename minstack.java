// Time Complexity :O(1)
// Space Complexity :O(1 but 29/31 testcases passed)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class MinStack {
    private int top = -1;
    private int max = 100000;
    private int stack[] = new int[max];
    private int min;
    private int x;
    private int prevmin;
    
    public MinStack() {
        // Constructor - nothing specific to initialize
    }
    
    public void push(int val) {
        // Pushes the given value onto the stack
        stack[++top] = val;
        
        if (top == 0) {
            min = stack[top]; // If the stack is empty, set the minimum as the first element
        }
        
        prevmin = min; // Store the previous minimum
        if (min >= val) {
            min = val; // Update the minimum if the new value is smaller
        }
    }
    
    public void pop() {
        // Removes the top element from the stack
        x = stack[top--];
        
        if (x == min) {
            min = prevmin; // If the popped element was the minimum, restore the previous minimum
        }
    }
    
    public int top() {
        // Returns the top element of the stack
        return stack[top];
    }
    
    public int getMin() {
        // Returns the minimum element in the stack
        if (top == 0) {
            return stack[top]; // If the stack has only one element, it is the minimum
        }
        return min;
    }
}

// Your code here along with comments explaining your approach
