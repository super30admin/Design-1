//Min-stack
// Time Complexity :O(1) for each operation
// Space Complexity : O(n) for stack 
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> st ;
    int min;
    public MinStack() {
        st= new Stack();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min){
            st.push(min);
            min=x;            
        }
        st.push(x);
    }
    
    public void pop() {
        int popped= st.pop();
        if(popped==min){
           min=st.pop();
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
