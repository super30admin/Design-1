// Time Complexity : O(1)
// Space Complexity :   O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We are using 2 stacks, one to store the values and the other one to store the min values at the time. 
// we push each element to the normal stack .. and compare the element with the current min value and push the min element to the min stack.
// while poppping we pop the elements from both the stacks and assign the min to the top element of the min stack.

import java.util.Stack;

class MinStack {
    private Stack<Integer> st = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        minstack.push(min);
    }
    
    public void push(int val) {
        st.push(val);
        if(val<min)
            min=val;
        minstack.push(min);
    }
    
    public void pop() {
        st.pop();
        minstack.pop();
        min = minstack.peek();
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