class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;

    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.minst = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        st.push(val);
        minst.push(min);
    }
    
    public void pop() {
        st.pop();
        minst.pop();
        min = minst.peek();
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