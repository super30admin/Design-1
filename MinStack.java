// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

import java.util.*;
class MinStack {

    Stack<Integer> st;

    // We take Integer.MAX_VALUE as min as it is given in the question that all operations will always be called on non-empty stacks
    int min = Integer.MAX_VALUE;

    public MinStack() {
        st = new Stack<Integer>();
    }

    public void push(int val) {
        st.push(val);
        if(val < min)
        {
            min = val;
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return  st.peek();
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