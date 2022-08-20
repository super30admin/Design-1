class MinStack {

    Stack<Integer> currentStack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        currentStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {

        min = Math.min(min,val);
        currentStack.push(val);
        minStack.push(min);

    }

    public void pop() {

        currentStack.pop();
        minStack.pop();
        minStack.peek();

    }

    public int top() {
        return currentStack.peek();

    }

    public int getMin() {
        return minStack.peek();

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
