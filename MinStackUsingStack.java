package design1;

import java.util.Stack;

public class MinStackUsingStack {
	int minVal;
    Stack<Integer> stack;
    public MinStackUsingStack() {
        minVal = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= minVal) {
            stack.push(minVal);
            minVal = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == minVal) {
            minVal = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minVal;
    }
}
