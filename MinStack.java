// Approach:
// We use two stacks: one to store all values and one to track minimums.
// Every time we push a new minimum, we store the old one on min stack to restore later when popping.
// This helps us get the current minimum in constant time.


// Time Complexity : O(1) for all operations: push, pop, top, getMin
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        // Main stack to store all values
        this.st = new Stack<>();
        // Min stack to store previous minimum values
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        // If the new value is smaller than current min, we push the old min to min stack
        if (val <= min) {
            minSt.push(min);
            min = val;
        }
        st.push(val); // Push value to main stack
    }

    public void pop() {
        int temp = st.pop();
        // If the popped value was the current min, restore the previous min from min stack
        if (temp == min) {
            min = minSt.pop();
        }
    }

    public int top() {
        // Return the top value from main stack
        return st.peek();
    }

    public int getMin() {
        // Return the current minimum
        return min;
    }
}
