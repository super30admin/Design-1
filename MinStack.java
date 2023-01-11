// Time Complexity : push:O(1) pop:O(1) getmin:O(1) top:O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    private int min;
    private Stack<Integer> st;
    private Stack<Integer> min_st;

    public MinStack() {
        st = new Stack<>();
        min_st = new Stack<>();
        min = Integer.MAX_VALUE;
        min_st.push(min);        
    }
    
    public void push(int val) {
        st.push(val);
        min = Math.min(min, val);
        min_st.push(min);
        
    }
    
    public void pop() {
        st.pop();
        min_st.pop();
        min = min_st.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
       return min_st.peek(); 
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