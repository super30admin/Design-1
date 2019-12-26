class MinStack {
    
    private Stack<Integer> primaryStack = new Stack<Integer>();
    private Stack<Integer> secondaryStack = new Stack<Integer>();
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        primaryStack.push(x);
        if(x <= min) {
            secondaryStack.push(min); 
        	secondaryStack.push(x);
            min = x;
        }else {
        	secondaryStack.push(min);
        }        
    }
    
    public void pop() {
    	int k = primaryStack.peek();
        if(k == min){
            secondaryStack.pop();
            min = secondaryStack.pop();
            primaryStack.pop();
            
        }else{
            primaryStack.pop();
            secondaryStack.pop();
        }

    }
    
    public int top() {
    	return primaryStack.peek();
    }
    
    public int getMin() {
        return secondaryStack.peek();
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