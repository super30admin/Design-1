class MinStack {
    
    private Stack<int[]> st = new Stack<>();
    
    public MinStack() { }
    
    
    public void push(int val) {
        
         
        if (st.isEmpty()) { //if stack is empty
            st.push(new int[]{val, val});
            return;
        }
        
        st.push(new int[]{val, Math.min(val, st.peek()[1])});
    }
    
    
    public void pop() {
        st.pop(); // normal pop function
    }
    
    
    public int top() {
        return st.peek()[0]; // returning top element which is the first ele in the array
    }
    
    
    public int getMin() {
        return st.peek()[1]; // returning min ele which is the second ele in the array
    }
}