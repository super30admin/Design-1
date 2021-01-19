// Time Complexity :  O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : no

class MinStack {

    /** initialize your data structure here. */
    private int data;
    private int min;
    private Stack<Integer> st;
    
    public MinStack() {
        st = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min){           
            st.push(min);
            min = x;
        }
        st.push(x);
    }
    
    public void pop() {
        int popped = st.pop(); 
        if( popped == min){
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */