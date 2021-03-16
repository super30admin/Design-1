class MinStack {
    Stack<int[]> minstack;
    
    /** initialize your data structure here. */
    public MinStack() {
        minstack = new Stack();
    }
    
    public void push(int x) {
        if(!minstack.isEmpty())
        {
            int[] temp=minstack.peek();
            minstack.push(new int[]{x,Math.min(x,temp[1])});
        }
        else
            minstack.push(new int[]{x,x});
            
    }
    
    public void pop() {
        minstack.pop();
    }
    
    public int top() {
        int[] temp=minstack.peek();
        return temp[0];
    }
    
    public int getMin() {
        int[] temp=minstack.peek();
        return temp[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
