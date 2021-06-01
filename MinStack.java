class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack() {

        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {

        if(stack2.peek() < val){
            stack1.push(val);
            stack2.push(stack2.peek());
        }
        else{
            stack1.push(val);
            stack2.push(val);
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();

    }

    public int top() {

        return stack1.peek();

    }

    public int getMin() {
        return stack2.peek();

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