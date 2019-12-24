class MinStack {
Stack<Integer> stack = new Stack<Integer>();
Stack<Integer> min = new Stack<Integer>();

public void push(int x) {
    if(min.empty() || x <= min.peek())
        min.push(x);
    stack.push(x);
}

public void pop() {
    if(!stack.empty()){
        if((int)min.peek() == (int)stack.peek())
            min.pop();
        stack.pop();
    }
}

public int top() {
    if(!stack.empty()){
        return stack.peek();
    }
    return -1;
}

public int getMin() {
    return min.peek();
}
}