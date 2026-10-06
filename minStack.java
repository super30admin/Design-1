class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int value) {
        if(min > value){
            min = value;
        }
        s.push(value);
        minStack.push(min);
      
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// TC : O(1) we have O(1) operations in every function
//SC: O(N) N is number of push operations 