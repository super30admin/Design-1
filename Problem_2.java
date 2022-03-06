// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Initially I didnt get the idea to use an array inside stack

// Your code here along with comments explaining your approach

import java.util.Stack;

class MinStack {
    static Stack<Integer[]> st;

    public MinStack() {
        st = new Stack<Integer[]>();
    }

    // While pushing, push an array with [currentvalue, minValue of currentvalue and
    // previous minvalue]
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Integer[] { val, val });
        } else {
            st.push(new Integer[] { val, Math.min(val, st.peek()[1]) });
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
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