class MinStack {

    private Stack<Integer> s = new Stack<>();
    int m = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {

        // if a new minimum is encountered, push previous min
        if (x <= m) {
            s.push(m);
            m = x;
        }

        // push the new element
        s.push(x);
    }

    public void pop() {

        // pop the top element
        int p = s.pop();

        // if the popped element is same as minimum, pop the new minimum
        if (p == m) {
            m = s.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return m;
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
