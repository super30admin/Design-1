// Time Complexity : O(n)
// Space Complexity : O(2n)=O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot to add minStack pop in the pop function hence could not run in the 1st run

import java.util.Stack;

class MinStack {

    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> minSt = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {

        minSt.push(Integer.MAX_VALUE);

    }

    public void push(int x) {
        st.push(x);
        int min = Math.min(x, minSt.peek());
        minSt.push(min);
    }

    public void pop() {
        st.pop();
        minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */