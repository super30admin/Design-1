class MinStack {
    public Stack<Integer> Stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        Stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<= min)
        {
            Stack.push(min);
            min = val;
        }
        Stack.push(val);
    }
    
    public void pop() {
        if(min == Stack.pop())
        {
            min = Stack.pop();
        }
    }
    
    public int top() {
        return Stack.peek();
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