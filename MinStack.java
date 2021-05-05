// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Using two stacks, keep minimum value at Integer.MAX_VALUE to make sure when minStack is empty and peek is perfomed exception will not be thrown.
// For push operation, enter element in main stack and corresponding minimum element in min stack (By computing minimum between min and value to be entered)
// For pop operation, pop elements from min and main stacks but update min to be among elements present in minStack
// For top operation, peek on main Stack
// For min operation, return min value maintained.

// Your code here along with comments explaining your approach
class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    private int min;
    /** initialize your data s
    tructure here. */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
        // Setting minimum value in minStack to be max value to make sure when peeking empty stack exception will not be generated
        min = Integer.MAX_VALUE;
        minStack.push(min);    
    }
    
    public void push(int val) {
        // Find minimum value among value to be entered and last min value
        min = Math.min(val, min);
        mainStack.push(val);
        minStack.push(min);        
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
        // To make sure after elements are deleted the minimum value is updated from present elements
        min = minStack.peek();        
    }
    
    public int top() {
        return mainStack.peek();
    }
    
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
