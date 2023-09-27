//Approach - taking 2 stacks and acting one stack as our lookup
// Time o(1)
// Space o(1) -- size of stacks

class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minStack;
    private int min;


    public MinStack() {
        this.st = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.minStack.push(min);


    }

    public void push(int val) {
        min = Math.min(min, val);
        this.st.push(val);
        this.minStack.push(min);
    }

    public void pop() {
        this.st.pop();
        this.minStack.pop();
        this.min = minStack.peek();
    }

    public int top() {


        return this.st.peek();
    }

    public int getMin() {
        return this.min;
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