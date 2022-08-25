class MinStack {
    private Stack<Integer> elementStack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        this.elementStack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        //compare values and get min
        min=Math.min(min,val);
        elementStack.push(val);
        minStack.push(min);
    }

    public void pop() {
        elementStack.pop();
        minStack.pop();
        min=minStack.peek();
    }

    public int top() {
        return elementStack.peek();
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