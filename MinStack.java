class MinStack {

    Stack<Integer> st=new Stack();
    Stack<Integer> minst=new Stack();
    int min=Integer.MAX_VALUE;

    public MinStack() {  
        minst.push(min);
    }
    
    public void push(int val) {
        st.push(val);
        if(val<=min)
        {
            minst.push(min);
            min=val;
        }
        // min=Math.min(min,val);
        // minst.push(min);
        
    }
    
    public void pop() {

        if(min==st.pop()){
            min=minst.pop();
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