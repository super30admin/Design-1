class MinStack {
    //Create stack1 and global variable min
      Stack<Integer> stack1;
      int min;

    /** initialize your data structure here. */
    public MinStack() {
      stack1 = new Stack<Integer>();  
	  min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<= min){
            stack1.push(min);   //previous min
            min = x;
        }
            stack1.push(x);
    }
    
    public void pop() {
        //pop only when minimum
        if(stack1.pop()== min){
            min = stack1.pop();
        }
        
    }
    
    public int top() {
        return stack1.peek();        
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