// Time Complexity :O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes.

## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

class MinStack {
    private Stack<int[]> st = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val,val});
        } else{
            st.push(new int[]{val, Math.min(val, st.peek()[1])});
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