class MinStack {
    Stack<Integer> s;
    Stack<Integer> minstack;
    int min;
    public MinStack() {
        s = new Stack<>();
        minstack = new Stack<>();
        min = Integer.MAX_VALUE;
        minstack.push(min);
    }
    
    public void push(int val) {
        s.push(val);
        if(val < min)
        {
            min = val;
            minstack.push(val);
        }
        else
        {
            minstack.push(min);
        }
    }
    
    public void pop() {
        s.pop();
        minstack.pop();
        min = minstack.peek();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
