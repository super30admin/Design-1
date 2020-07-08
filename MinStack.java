// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Did'nt know of using single stack to find min, had 2 stack approach in mind.

import java.util.Stack;

class MinStack {
	
	Stack <Integer> stack = new Stack<>();
    int minValue = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
    	//if x is less than or equal to min, then push to stack and make x as min
        if(x <= minValue){
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        int popped = stack.pop();
        // if popped value is equal to min, then make it as min
        if(popped == minValue)
            minValue = stack.pop();
    }
    
    public int top() {
        return stack.peek();    
    }
    
    public int getMin() {
        return minValue;
    }
    
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	System.out.println("returns " +minStack.getMin());
    	minStack.pop();
    	System.out.println("returns " +minStack.top());
    	System.out.println("returns " +minStack.getMin());
    }
}
