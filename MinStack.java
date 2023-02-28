import java.util.Stack;


//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


public class MinStack {

    
	Stack<Integer> stack1;
    Stack<Integer> minStack;
	
	 	public MinStack() {
	 		stack1 = new Stack<Integer>();
	 	    minStack = new Stack<Integer>();
	    }
	    
	    public void push(int val) {
	        if(minStack.isEmpty() || minStack.peek() >= val) {
	        	minStack.push(val);
	        }
	        stack1.push(val);
	    }
	    
	    public void pop() {
	        if(stack1.peek().equals(minStack.peek())) {
	        	minStack.pop();
	        }
	        stack1.pop();
	    }
	    
	    public int top() {
	        return stack1.peek();
	    }
	    
	    public int getMin() {
	           return minStack.peek();
	    }

}