/*

Time : 0(1)



*/



class MinStack {
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    int min;
    public MinStack() {
        minStack = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val <= min ){
            minStack.push(min);
            min = val;
        }
        
        minStack.push(val);
         
    }
    
    public void pop() {
        if (minStack.pop() == min){    // pop and check if min pop again
            min = minStack.pop();
        }      
    }
    
    public int top() {
        return minStack.peek();
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