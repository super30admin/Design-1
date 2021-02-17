class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s;
    Integer minimum;
    public MinStack() {
       s =new Stack<Integer>();
        minimum=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        
        if(x<=minimum)
        {
             s.push(minimum);
            minimum=x;
        }
        else
        {
            s.push(minimum);
        }
       
         s.push(x);
    }
    
    public void pop() {
        
       s.pop();
        minimum=s.pop();
        
       
    }
    
    public int top() {
   return  s.peek();   
    }
    
    public int getMin() {
        return minimum;
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