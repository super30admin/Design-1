// Approach is to use two stacks. One for regular values and the other for minimum values. We will maintain a 1:1 mapping.
// For every new item we push to the stack, we push the current minimum value as well
// Also make sure to push integer.max value to the empty min stack to avoid empty stack exception

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {  
       stack = new Stack<Integer>();
       minStack = new Stack<Integer>();
       minStack.push(Integer.MAX_VALUE);
    }
    
    // O(1)
    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }
    
    // O(1)
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    // O(1)
    public int top() {
        return stack.peek();
    }
    
    // O(1)
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