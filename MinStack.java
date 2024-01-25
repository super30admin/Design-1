class MinStack {

    private Stack<Integer> minstack;
    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack();
        this.minstack = new MinStack()
    }

    public void push(int val) {
        stack.push(val);
        if(val <= min){
            minstack.push(val);
            min = val;
        }
    }

    public void pop() {
        if(stack.empty()) return;

        int val = stack.pop();
        if(val == min) {
            minstack.pop(val);
            min = minstack.peek()
        }

    }

    public int top() {
        stack.peek();
    }

    public int getMin() {
        retun min;
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