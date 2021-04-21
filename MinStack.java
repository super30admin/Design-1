class MinStack {
    
    Stack<Integer> stck;
    Stack<Integer> minstack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stck = new Stack<>();
        minstack = new Stack<>();
        min = Integer.MAX_VALUE;
        minstack.push(Integer.MAX_VALUE);
        
        
    }
    
    public void push(int val) {
        stck.push(val);
        if(min > val){
            min = val;
        }
        minstack.push(min);
        
    }
    
    public void pop() {
        stck.pop();
        minstack.pop();
        min = minstack.peek();
        
    }
    
    public int top() {
        return stck.peek();
        
        
    }
    
    public int getMin() {
        if(!minstack.isEmpty()){
        return min;
        }
        return -1;
        
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
