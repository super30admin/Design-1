class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        minStack.push(min);
    }
    
    public void push(int val) {
        stack.push(val);
        if(val<min) {
            minStack.push(val);
            min = val;
        }
        else{
            minStack.push(min);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
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