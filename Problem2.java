class MinStack {
    private Stack<Integer> single;
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
    single=new Stack<>();
    min=Integer.MAX_VALUE;
    single.push(min);
    }
    
    public void push(int val) {
    if(val <= min)
    {
        single.push(min);
        min=val;
    }
        single.push(val);
    }
    
    public void pop() {
    if (single.pop()==min)
    {
        min=single.pop();
    }
    }
    
    public int top() {
        return single.peek();
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