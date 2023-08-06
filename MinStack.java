class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;


    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
         min = Math.min(min, val);
         stack.push(val);
         minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        this.min = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
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