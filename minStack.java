class MinStack {

    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack=new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        
        if(val<=min)
        {
            stack.push(min);
            min=val;
        }
        
        stack.push(val);
        
    }
    
    public void pop() {
        
        if(min==stack.peek())
        {
            stack.pop();
            min=stack.peek();
        }
        stack.pop();
        
    }
    
    public int top() {
        
        return stack.peek();
        
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