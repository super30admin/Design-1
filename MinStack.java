import java.util.Stack;

class MinStack {
Stack<Integer> mainStack;
Stack<Integer> minStack;
Integer min;
    /** initialize your data structure here. */
    public MinStack() {
    	min= Integer.MAX_VALUE;
        mainStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        minStack.push(min);
        
    }
    
    public void push(int x) {
        min=Math.min(min, x);
        mainStack.push(x);
        minStack.push(min);
    }
    
    public void pop() {
    	mainStack.pop();
    	minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
    return	mainStack.peek();
        
    }
    
    public int getMin() {
    	return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
