import java.util.Stack;

class MinStack {
    
    Stack<Integer> stack;
    
    Stack<Integer> minStack;
    
    int currentMinimum;

    public MinStack() {
        currentMinimum = Integer.MAX_VALUE;
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(currentMinimum);
    }
    
    public void push(int val) {
        stack.push(val);
        currentMinimum = Math.min(val, currentMinimum);
        minStack.push(currentMinimum);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}