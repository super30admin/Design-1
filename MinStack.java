class MinStack {

	int count=0;
	int min=Integer.MAX_VALUE;
	 Stack stack1 = new Stack(); 
	 Stack stack2=new Stack();
    /** initialize your data structure here. */
    public MinStack() {
    	
    }
    
    public void push(int x) {
    	if(stack2.isEmpty()) {
    		stack2.push(x);
    		stack1.push(x);
    	
    	}
    	else
    	{
    		min=Math.min(stack2.peek(),x);
    		if(min!=stack2.peek())
    			stack2.push(min);
    		stack1.push(x);
    	}
    }
    
    public void pop() {
        int t=stack1.pop();
        if(stack2.peek()==t)
        	stack2.pop();
    }
    
    public int top() {
    return stack1.peek();
    }
    
    public int getMin() {
       return stack2.pop();
    }
    
    public static void main(String args[])
    {
    	MinStack minStack = new MinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	System.out.println("minimum="+minStack.getMin()); // return -3
    	minStack.pop();
    	System.out.println("top"+minStack.top());    // return 0
    	System.out.println("min="+minStack.getMin()); // return -2
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