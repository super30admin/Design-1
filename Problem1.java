// Time Complexity : O(n)
// Space Complexity : O(2n)=O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot to add minStack pop in the pop function hence could not run in the 1st run

//Using a single stack it pushes previous minimum and pushes current element accordingly. While popping up the code checks if the minimum equals the current minimum and if yes it pops one more value which is assigned to minimum. This is the previous minimum

import java.util.Stack;

class MinStack {

    Stack<Integer> st;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

        st = new Stack<Integer>();

    }

    public void push(int x) {
        if (x <= min) {
            st.push(min);
            min = x;
        }
        st.push(x);
    }

    public void pop() {
        int pop = st.pop();
        if (pop == min) {
            min = st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */