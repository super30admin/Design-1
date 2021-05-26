class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack,temp;
    public MinStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(val<getMin()){
            temp.push(val);
        }

    }

    public void pop() {
        int element = stack.pop();
        if(element == getMin())
            temp.pop();

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        if(temp.isEmpty())
            return Integer.MAX_VALUE;
        return temp.peek();

    }
}

