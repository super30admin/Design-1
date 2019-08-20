class MinStack {

    /** initialize your data structure here. */
    public MinStack() {
        MinStack<Integer> min = new MinStack<>(); 
    }
    
    public void push(int x) {
        if(isEmpty() == true) 
        { 
            super.push(x); 
            min.push(x); 
        } 
        else
        { 
            super.push(x); 
            int y = min.pop(); 
            min.push(y); 
            if(x < y) 
                min.push(x); 
            else
                min.push(y); 
        } 
    }
    
    public void pop() {
        int x = super.pop(); 
        min.pop(); 
        return x; 
    }
    
    public int top() {
        
    }
    
    public int getMin() {
        int x = min.pop(); 
        min.push(x); 
        return x; 
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

 // Special stack has been implememted using stack data structure in Java
 //time complexity O(1)