class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.empty())
        {
            stack.push(val);
            min = val;
        }
        else if(val>min)
        {
            stack.push(val);
        }
        else
        {
            stack.push(min);
            stack.push(val);
            min = val;
        }
    }
    
    public void pop() {
        stack.pop();
        min = stack.peek();
        stack.pop();
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