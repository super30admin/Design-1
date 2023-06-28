
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class MinStack {
	
	Stack<Integer> stack;
	int min;

	public MinStack() {
		this.stack = new Stack<Integer>();
		//this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
    	if(stack.isEmpty())
    	{
    		stack.push(val); //pushing the previous minimum value
    		stack.push(val); 	////pushing the value
    		min = val;
    		return;
    	}
    		
    	if(val <= min)
    	{
    		stack.push(min);	// pushing the minimum to be stored as previous minimum
    		min = val;		//storing the current value as minimum value
    	}
    	stack.push(val); //pushing the current value 
    }
    
    public void pop() {
    	if(!stack.isEmpty())
    	{
	    	int popValue = stack.pop();
	    	if(popValue == min)
	    	{
	    		min = stack.pop();
	    	}
    	}
    }
    
    public int top() {
       	return stack.peek();
        
    }
    
    public int getMin() {
    	return min;
        
    }
    
    public static void main(String args[])
    {
    	MinStack minStack = new MinStack();
    	minStack.push(3);
    	minStack.push(-2);
    	minStack.pop();
    	minStack.pop();
    }
}
