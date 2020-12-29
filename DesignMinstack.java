class MinStack {

    Stack<Integer> st;
    Integer min;
    /** initialize your data structure here. */
    public MinStack() {
     st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    //TC - O(1) 
    public void push(int x) {
        if(x <= min){
            st.push(min);
            min = x;
        }
        st.push(x);
    }
    //TC - O(1) 
    public void pop() {
        int popped = st.pop();
        if(popped == min){
            min = st.pop();
        }
    }
    //TC - O(1) 
    public int top() {
        return st.peek();
    }
    //TC - O(1) 
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
