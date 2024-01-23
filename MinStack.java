//time complexity - O(1). The approach for Min stack involves 2 stacks. One does normal stack operations the other one minstack keeps track of min element.
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty() || val <= minstack.peek()){
           minstack.push(val);
        }
        
    }
    
    public void pop() {
        
        if(!stack.isEmpty()){
            if(stack.pop().equals( minstack.peek())){
                minstack.pop();
            }
        }
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        throw new IllegalStateException("Stack is empty");
    }
    
    public int getMin() {
        if(!minstack.isEmpty()){
            return minstack.peek();
        }
        throw new IllegalStateException("Stack is empty");
        
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
