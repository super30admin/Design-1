class MinStack {
    Stack<Integer> s;//contains all elements
    Stack<Integer> minStack; //contains only min elements
    int min; 

    public MinStack() {
        s=new Stack<>();
        minStack=new Stack<>();
        min=Integer.MAX_VALUE; //Max value of Integer
        minStack.push(min);
    }
    
    public void push(int val) {
        if(val<=min)
            min=val;
        s.push(val);//pushing value
        minStack.push(min);//pushing min value
    }
    
    public void pop() {
        s.pop();
        minStack.pop();//popping both Stacks at same time
        min=minStack.peek();//updating min
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
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


//Time Complexity: O(1)
//Space Complexity: O(n), n=elements stored in stack
