class MinStack {
    
    Stack <Integer> st;
    Stack <Integer> minstack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        minstack = new Stack<>();
        min = Integer.MAX_VALUE;
        minstack.push(min);
    }
    
    public void push(int x) {
        min = Math.min(x, min);
        st.push(x);
        minstack.push(min);
    }
    
    public void pop() {
        st.pop();
        minstack.pop();
        min = minstack.peek();
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return min;
    }
}
