class MinStack {
    // Creating two stacks one for storing the values and the other for storing the min
    Stack<Integer> stk;
    Stack<Integer> minst;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        // Initializing the stack and minstacks and min value to MAX value
        stk = new Stack<>();
        minst = new Stack<>();
        min = Integer.MAX_VALUE;
        minst.push(min);
        
    }
    
    public void push(int val) {
        // finding the min first and then pushing the val to main stack and min value to the min stack
        min = Math.min(min,val);
        stk.push(val);
        minst.push(min);
        
    }
    
    public void pop() {
        stk.pop();
        minst.pop();
        // storing the min by peeking into the min stack
        min = minst.peek();
        
    }
    
    public int top() {
        
        return stk.peek();
        
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



1. elgible or not. Notice period 
 2. while applying for documents.no due and agreement