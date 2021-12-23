//time complexity o(1) for push
//o(1) for pop and for peek and top too
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek()>=val){
            minStack.push(val);
        }

        stack.push(val);

    }

    public void pop() {
        if(stack.peek()==minStack.peek()){

            minStack.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
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