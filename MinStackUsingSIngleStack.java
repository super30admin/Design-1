class MinStack {

    Stack<Integer> minStack;
    int min;

    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }

    public void pop() {
        int val = minStack.pop();
        if(val == min) {
            min = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
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