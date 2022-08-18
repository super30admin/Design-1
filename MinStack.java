
class MinStack {
 Stack<Integer> stack; // Stack 1 used for 1:1 Mapping
 Stack<Integer>minstack; // Stack 2 used for 1:1 Mapping
 int minimum;    // Minimum value for the Stack
    
    public MinStack() {
        this.stack = new Stack<>();
        this.minstack = new Stack<>();
        this.minimum = Integer.MAX_VALUE;  // The maximum value for Integer which is initally  stored as minimum
    }
    
    public void push(int val) {
        if(stack.empty()==true)
        {
            minstack.push(Integer.MAX_VALUE); 
        }
        if(val<minimum)
        {
            minimum = val;
        }
        
        stack.push(val);
        minstack.push(minimum);
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
        minimum = minstack.peek();
            
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
         return minimum;
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