class MinStack {
    Stack <Integer> st;
    Stack <Integer> minSt;
    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    
    public void push(int val) {
        st.push(val);
        min = Math.min(min,val);
        minSt.push(min);
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}