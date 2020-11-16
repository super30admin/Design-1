class MinStack {

    Stack<Integer> stack;
    Integer min;
    /** initialize your data structure here. */
    public MinStack() {
         stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            min = x;
        }
        if(x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == min){
            min = stack.peek();
            stack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}