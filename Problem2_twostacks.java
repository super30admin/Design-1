class MinStack {
    int global_minimum = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    //Current Stack Value
    Stack<Integer> s1 = new Stack<>();
    //previous minimum 
    Stack<Integer> s2 = new Stack<>();
    public MinStack() {
        //s.push(global_minimum);
        s2.push(global_minimum);
    }
    
    public void push(int x) {
        if(x <= global_minimum){
            //change global minimum
            s1.push(x);
            global_minimum = x;
            s2.push(global_minimum);
        }else{
            //no change in global minimum
            s1.push(x);
            s2.push(global_minimum);
        }
    }
    
    public void pop() {
        if(!s1.isEmpty()){
            //Pop first element of the stack
            s1.pop();
            int check_value = s2.pop();
            if(check_value <= global_minimum){
                //change global minimum
                global_minimum = s2.peek();
            }
                
        }
    }
    
    public int top() {
        if(!s1.isEmpty()){
            return s1.peek();
        }
        return -1;
        
    }
    
    public int getMin() {
        return global_minimum;
        
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
