class MinStack {

    Stack<Integer> s;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;

    }

    public void push(int val) {
        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
    }

    public void pop() {
        int top = s.pop();
        if(top == min){
            min = s.pop();
        }

    }

    public int top() {
        return  s.peek();
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