class MinStack {
    
    int min_element;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<Integer>();
        min_element = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min_element) {
            stack.push(min_element);
            min_element = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == min_element) {
            min_element = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_element;
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
