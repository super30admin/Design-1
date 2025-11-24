// Time Complexity : O(1) for push, pop, top, and getMin
// Space Complexity : O(n) due to the auxiliary min stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No major issues; logic of syncing the two stacks was important.

// I used two stacks — one to store values and another to track the minimum values.
// Every time a new value is pushed, it is also pushed to the min stack if it is smaller or equal to the current minimum.
// When popping, if the popped value equals the min stack's top, I pop from the min stack as well to maintain correct minimum tracking.
class MinStack {

    Stack<Integer> st;        // main stack
    Stack<Integer> minStack;  // keeps track of minimum values

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);

        // If minStack is empty OR new value is <= current min, push it
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int removed = st.pop();

        // If removed element is the current minimum, pop from minStack also
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

