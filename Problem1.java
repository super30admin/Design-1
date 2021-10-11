import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Need to track Min for each entry into stack
 */
class MinStack {
    
    Stack<int []> st;
    int [] arr;

    public MinStack() {
        st = new Stack<int []>();
        arr = new int[2];
    }
    
    public void push(int val) {   
        if(st.isEmpty() || val < st.peek()[1]){
            st.push(new int[] {val, val});
        }else {
            st.push(new int[] {val, st.peek()[1]});
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){st.pop();}
    }
    
    public int top() {
        if(!st.isEmpty()){arr = st.peek();}
        return arr[0];
    }
    
    public int getMin() {
        if(!st.isEmpty()){arr = st.peek();}
        return arr[1];
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