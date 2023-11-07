// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : - 

import java.util.Stack;

//Use two stacks, one original and another min stack.
//push a value to min stack first time and next only if it contains a value greater than 
//existing value. While popping, make sure if same value is in min stack, it needs to be 
//popped too
class MinStack {
    Stack<Integer> st = null;
    Stack<Integer> min = null;

    public MinStack() {
        st = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int val) {
        if(min.isEmpty() || min.peek() >= val)
            min.push(val);
        st.push(val);
    }

    public void pop() {
        if(st.peek()== min.peek())
            min.pop();
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
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