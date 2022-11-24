import java.util.Stack;

class MinStack {
    private Stack <Integer> stack1;
    private Stack <Integer> minStack;
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
        stack1 = new Stack<Integer>();
        minStack = new Stack<Integer>();
        minStack.push(min);
    }
    
    public void push(int val) {
        stack1.push(val);
        min = Math.min(val, min);
        minStack.push(min);
        
    }
    
    public void pop() {
        stack1.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return stack1.peek();
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