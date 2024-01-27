// Time Complexity : O(1) for all operations
//Space Complexity : O(1) for all operations



class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    int minimumValue;
    public MinStack() {
        this.st = new Stack();
        this.minStack = new Stack();
        this.minimumValue= Integer.MAX_VALUE;
        this.minStack.push(this.minimumValue);
    }
    
    public void push(int val) {
        minimumValue = Math.min(this.minimumValue, val);
        this.st.push(val);
        this.minStack.push(minimumValue);
    }
    
    public void pop() {
        this.st.pop();
        this.minStack.pop();
        this.minimumValue = minStack.peek();

    }
    
    public int top() {
        return this.st.peek();
    }
    
    public int getMin() {
        return this.minimumValue;
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