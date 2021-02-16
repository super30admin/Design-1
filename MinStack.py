class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    //stack.push(min);
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(x<=min)
        {
            stack.push(min);
            min = x;
        }
        stack.push(x);
        
    }
    
    public void pop() {
        int popValue = stack.pop();
        if(popValue==min)
        {
            min = stack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(stack.empty())
            return -1;
        else
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