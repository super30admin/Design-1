import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MinStack {

    // instantiated normal stack and min stack

    Stack<Integer> st = new Stack<>();
    Stack<Integer> min_st = new Stack<>();

    public void push(int val) {
        // Pushing elements on to min stack only for the first time push and the value
        // pushed is less than the existing peek value of the min_stack
        if (min_st.isEmpty() || val <= min_st.peek()) {
            min_st.push(val);
        }
        // Pushing all the values in to the normal stack
        st.push(val);

    }

    public void pop() {
        // popping the element from the min stack only if the peek of normal and min
        // stack are same
        if (st.peek().equals(min_st.peek())) {
            min_st.pop();
        }
        // Popping every elemnt from the normal stack whenever pop is called.
        st.pop();

    }

    public int top() {
        // returning peek value of the normal stack
        return st.peek();

    }

    public int getMin() {
        // the peek element of the min stack is always the minimum
        return min_st.peek();

    }

}