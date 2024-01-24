// Time Complexity : O(1) for all operations
// Space Complexity : O(N) for the extra stack
// Did this code successfully run on Leetcode : Yes

// Approach - Use two Stacks (st and minStack). 
//Push - If the element being pushed is smaller than the current minimum push it to minstack.
//Pop - If the element being popped is current minimum. Pop from minstack as well.
//getMin - The element on top of the minstack is the current minimum.

import java.util.Stack;

class MinStack {

    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack() {
        this.st = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        int poppedVal = st.pop();
        if (poppedVal == minStack.peek()) {
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
