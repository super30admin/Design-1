class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack,minstack;
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        if(minstack.empty())
        {
            stack.push(val);
            minstack.push(val);
        }
        else if(val>minstack.peek())
        {
            int min = minstack.peek();
            minstack.push(min);
            stack.push(val);
        }
        else{
        stack.push(val);
        minstack.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
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