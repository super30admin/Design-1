//Time Complexity : O(1)
//Space Complexity : O(n).
//Solution accepted and submitted on Leetcode.

import java.util.Stack;

class MinStack{
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    int min;

    public MinStack() {
    	stack = new Stack<>();
    	minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    	min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
