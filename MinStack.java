class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
    }
    
    public void push(int val) {
        this.st.push(val);

        if(minSt.isEmpty() || val <= minSt.peek()){
            minSt.push(val);

        }
        
    }
    
    public void pop() {

        int popVal = st.pop();
        if(minSt.peek() == popVal ){
            minSt.pop();
        }
        
    }
    
    public int top() {
        return st.peek();  
        
    }
    
    public int getMin() {
       return minSt.peek();
        
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