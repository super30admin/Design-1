// Time Complexity :
// push(val)  -> O(1)
// pop()      -> O(1)
// top()      -> O(1)
// getMin()   -> O(1)
//
// Space Complexity :
// O(N) where N is the number of elements in the stack
// (We use two stacks: one for values, one for tracking minimums)
//
// Did this code successfully run on Leetcode :
// Yes
//
// Any problem you faced while coding this :
// No major issues. The key idea was to:
// - Keep an extra stack to track the minimum at each level
// - Always push the current minimum along with each value
// - Update the min correctly after pop using the min stack


// Your code here along with comments explaining your approach

import java.util.Stack;

class MinStack {

    // Main stack to store all values
    private Stack<Integer> mainst;

    // Auxiliary stack to store the minimum value at each level
    private Stack<Integer> minst;

    // Variable to track current minimum
    private int min;

    public MinStack() {
        this.mainst = new Stack<>();
        this.minst = new Stack<>();

        // Initialize min with maximum possible value
        this.min = Integer.MAX_VALUE;

        // Push initial min so that peek() is always safe
        this.minst.push(this.min);
    }
    
    public void push(int val) {
        // Update the current minimum
        min = Math.min(min, val);

        // Push value into main stack
        mainst.push(val);

        // Push the updated minimum into min stack
        minst.push(min);
    }
    
    public void pop() {
        // Pop from both stacks to keep them in sync
        mainst.pop();
        minst.pop();

        // Update current min to the new top of min stack
        min = minst.peek();
    }
    
    public int top() {
        // Return the top of the main stack
        return mainst.peek();
    }
    
    public int getMin() {
        // Return the current minimum value
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
