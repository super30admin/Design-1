// Time Complexity : push: O(1); pop: O(1); top: O(1); getMin:O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MinStack {

    //create single stack and min tracker
    //when min is larger or equal than/to current val, push both values(current val, previous min) onto stack and set min to current val
    //when popping off if the current val is equal to min then min is stack.pop()
    Stack<Integer> st = new Stack<>();
    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(min >= val){
            st.push(min);
            min = val;
        }
        st.push(val);

    }

    public void pop() {
        if(st.pop() == min){
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