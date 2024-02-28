class MinStack {
    
    /**
    
        Thought Process:
        Single Stack
        
        Push -> If val <= min, push min, update min, push val
        Pop -> pop top, compare with min, if same, pop and update min

        TC: For all the methods - push, pop, top and getMin works at O(1)
        SC: O(N) as we use a Stack whose max size can go 2N if input is in descending order.
        Did this code successfully run on Leetcode : Yes
        Any problem you faced while coding this : No
    
    **/
  
   Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.minStack = new Stack();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min){
            this.minStack.push(min);
            this.min = val;
        }
        this.minStack.push(val);
    }
    
    public void pop() {
        if(this.minStack.pop() == this.min){
            this.min = this.minStack.pop();
        }
    }
    
    public int top() {
        return this.minStack.peek();
    }
    
    public int getMin() {
        return this.min;
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
