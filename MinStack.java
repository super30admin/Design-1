// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

import java.util.Stack;

/*
Use 2 stacks for original values and another for min values
A variable min will record min of the values during push
*/
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        st = new Stack<>();
        minSt = new Stack<>();
        // minSt.push(min);
    }

    public void push(int val) {
        //Update min if val is less than min and push previous min to minSt
        //When a min input is repeated, we need to push to minSt too
        if(val <= min) {
            minSt.push(min);
            min = val;
        }
        st.push(val);
    }

    public void pop() {
        if(min == st.pop())
            min = minSt.pop();
    }

    public int top() {
        return st.peek();
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