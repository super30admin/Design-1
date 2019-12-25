class MinStack {
Stack<Integer> stack = new Stack<Integer>();
Stack<Integer> min = new Stack<Integer>();
int Minimum = Integer.MAX_VALUE;
    
    public MinStack(){
        min.push(Minimum);
    }

    public void push(int x) {
    stack.push(x);
    if(x <= Minimum){
        Minimum = x;
    }
    min.push(Minimum);
    
}

public void pop() {
    if(stack.empty() == false){
        stack.pop();
        min.pop();
    }
    Minimum = min.peek();
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