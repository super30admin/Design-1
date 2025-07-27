// I used two stacks to track all elements and the current minimums.
// The minSt stack stores the previous minimums before each new minimum is pushed.
// This ensures that getMin() and pop() always work in constant time without scanning the entire stack.

// Time Complexity : O(1) for all operations — push, pop, top, getMin.
// Space Complexity : O(N) where N is the number of elements in the stack (extra space for minSt)
// Did this code successfully run on Leetcode : Yes



import java.util.*;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    // Push element and update min if needed
    public void push(int val) {
        // If new val is less than or equal to current min, store old min before updating
        if (val <= min) {
            minSt.push(min);
            min = val;
        }
        st.push(val);
    }

    // Pop element and update min if needed
    public void pop() {
        int temp = st.pop();
        // If popped value was the minimum, restore previous minimum
        if (temp == min) {
            min = minSt.pop();
        }
    }

    // Return top of stack
    public int top() {
        return st.peek();
    }

    // Return current minimum
    public int getMin() {
        return min;
    }
}
