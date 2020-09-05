Dclass MinStack {

    /** initialize your data structure here. */
    int min =  Integer.MAX_VALUE;
    Stack<Integer> stack;
    Stack<Integer> minStack ;
    
    public MinStack() {
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
    minStack.push(min);
    }
    
    public void push(int x) {
        if(x<=min){
            min = x;
            minStack.push(x);
        }
           stack.push(x);
        
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        int val = stack.pop();
        if(val==min){
            minStack.pop();
            min = minStack.peek();
        }
            
        
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */