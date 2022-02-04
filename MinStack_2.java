// Time Complexity : Push - O(1), Pop - O(1)
// Space Complexity : O(N) - worst case, if all the elements are min in descending order
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;

class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    int minValue = Integer.MAX_VALUE; // Default value taking MAX_VALUE as infinity

    public MinStack() {
        // To store default all elements
        mainStack = new Stack<Integer>();
        // Storing elems when elem <= min_elem
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        // Initial check with default, later updating in the pop method
        if (val <= minValue) {
            minValue = val;
            minStack.push(val);
        }
        mainStack.push(val);
    }

    public void pop() {
        if (top() == getMin()) {
            // Pop from minStack
            minStack.pop();
            // Storing the current min to compare while popping
            minValue = getMin();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
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