class MinStack {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minstack=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
         if (!minstack.isEmpty()) {
            if (minstack.peek() >= val) {
                minstack.push(val);
            } else if (minstack.peek() < val) {
                minstack.push(minstack.peek());
            }

        } else {
            minstack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
           if(!minstack.isEmpty() && !stack.isEmpty()) {
        stack.pop();
        minstack.pop();
        }
    }
    
    public int top() {
               if(!stack.isEmpty()){
            return stack.peek();
        }
        else
            return -1 ;
    }
    
    public int getMin() {
        if(!minstack.isEmpty()){
            return minstack.peek();
        }
        else
            return -1 ;
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