class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s ;
    Stack<Integer> minStack;
    int min;
    
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    void push(int val) {
        
        if(val <= min){
            min = val;
        }
        s.push(val);
        minStack.push(min);
    }
    
    void pop() {
       s.pop();
        minStack.pop();
        min =minStack.peek();
    }
    
    int top() {
        return s.peek() ;
        
    }
    
    int getMin() {
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
