class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        s.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
}

