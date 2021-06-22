class MinStack {

    // Time Complexity : O(1)
    // Space Complexity : O(n)
    
    Stack<Integer> st;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        st.push(min);
    }
    
    public void push(int val) {
        if (val <= min) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        int cur = st.pop();
        if (cur == min) {
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */