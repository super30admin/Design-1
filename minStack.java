class MinStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public MinStack() {
       // top = -1;
    }
    
    public void push(int val) {
        stack1.push(val);
    
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);

        }
        
    }
    
    public void pop() {
    
    if(minStack.peek().equals(stack1.peek())){   
       minStack.pop();
    }
        stack1.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
      
        return minStack.peek();
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