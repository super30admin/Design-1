class MinStack {
    
    Stack<Integer> Stack1;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        Stack1 = new Stack<Integer>();
        minStack = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        Stack1.push(x);
        if(minStack.empty()) {
           minStack.push(x);
        } else {
            int min = minStack.peek();
            minStack.push(x > min ? min : x);
        }
        
        
    }
    
    public void pop() {
        if(!isEmpty()) {
            Stack1.pop();
            minStack.pop();
        } 
        
    }
    
    public int top() {
        return Stack1.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
    
    public boolean isEmpty() {
        return Stack1.empty();
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
