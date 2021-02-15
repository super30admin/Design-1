class MinStack {
    
    /** initialize your data structure here. */
    Stack<Integer> minStack;
    int min;
    public MinStack() {
       minStack = new Stack<>();
       min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min){
            minStack.push(min);
            min=x;
        }
        minStack.push(x);
    }
    
    public void pop() {
        int popped = minStack.pop();
        if(min==popped){
            min = minStack.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
