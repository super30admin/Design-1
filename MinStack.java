// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.Stack;

// Your code here along with comments explaining your approach
/*
 * Maintain 2 different stacks, one keeps track of the minimum value at any given point while the other one simply pushes/pops element into/out of it.
 * Min stack push would depend upon whether the element being pushed is less than the current minimum, and would always have the minimum element at its top.
 *
 */
class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        st = new Stack<>();
        minSt = new Stack<>();
        minSt.push(min);
    }

    public void push(int val) {
        st.push(val);
        if(val <= min){
            minSt.push(val);
            min = val;

        }
    }

    public void pop() {
        int poppedEl = st.pop();
        if(poppedEl == min){
            minSt.pop(); // only pop from the min stack if the element being removed is the min element
        }
        min = minSt.peek();
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