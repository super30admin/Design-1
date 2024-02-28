/*
 * Time Complexity: O(1) for all push(), pop(), top(), getMin() functions
 * Spack Complexity: O(n) 
 */

class MinStack {
    Stack<Integer> stack = null, minStack = null;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || !minStack.isEmpty() && minStack.peek() >= val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int popped = stack.pop();
        if(popped == minStack.peek()) {
            minStack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
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