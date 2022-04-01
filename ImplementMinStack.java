class MinStack {
    int minValue;
    Stack<Integer> primaryStack;
    Stack<Integer> minStack;

    public MinStack() {
        minValue = Integer.MAX_VALUE;
        primaryStack = new Stack<>();
        minStack = new Stack<>();
        
        minStack.push(minValue);
        
    }
    
    public void push(int val) {
        primaryStack.push(val);
        if (val <= minValue) {
            minValue = val;
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        int topValue  = primaryStack.pop();
        if (topValue == minValue) {
            minStack.pop();
            minValue = minStack.peek();
        }
        
    }
    
    public int top() {
        return primaryStack.peek();
        
    }
    
    public int getMin() {
        if (minStack.size() == 1) {
            return 0;
        }
        return minValue;
        
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


class MinStack {
    int minValue;
    Stack<Integer> primaryStack;

    public MinStack() {
        minValue = Integer.MAX_VALUE;
        primaryStack = new Stack<>();
    }
    
    public void push(int val) {
        if (minValue >= val) {
            primaryStack.push(minValue);
            minValue = val;
        } 
        primaryStack.push(val);
        return;
    }
    
    public void pop() {
        int topValue  = primaryStack.pop();
        if (topValue == minValue) {
            minValue = primaryStack.pop();
        }
        
    }
    
    public int top() {
        return primaryStack.peek();
        
    }
    
    
    
    public int getMin() {
        return minValue;
        
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