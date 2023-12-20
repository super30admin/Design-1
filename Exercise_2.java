class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.minSt.push(this.min);
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minSt.push(min);
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        this.min = minSt.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}