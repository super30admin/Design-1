// Time Complexity : O(1) for all operations
// Space Complexity : O(n)
// Method used : Stack approach

class MinStack {
    
    Stack<Integer> stack;
    int minimum;

    public MinStack() {
        
        stack =new Stack();
        minimum = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        
        if(val <= minimum)
        {
            stack.push(minimum);
            minimum = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        
        if(stack.peek() == minimum)
        {
            stack.pop();
            minimum = stack.pop();
        }
        else stack.pop();
        
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        return minimum;
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