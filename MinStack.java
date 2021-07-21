class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> st;
    int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min)
        {
            st.push(min);
            min=val;   
        }
        st.push(val);
    }
    
    public void pop() {
        int top = st.pop();
        if(min == top)
        {
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
/*
    Time Complexity
    push - O(1)
    pop - O(1)
    top - O(1)
    getMin - O(1)

    Space Complexity - O(n) where n is the input size that are pushed in the stack.
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */