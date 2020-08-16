package design1;

import java.util.Stack;

//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack();		//to store elements in stack
        minStack=new Stack();	//to maintain stack of minimum elements
    }
    
    public void push(int x) {
    	
    	/*checks whether the stack is empty and pushes the element in 
    	the minstack if top of minstack is greater than or equal to given value*/
        if(minStack.isEmpty() || minStack.peek()>=x){
            minStack.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
    	/*
    	 * remove the peek element from minstack if it matches with the value of peek of stack
    	 */
        if(minStack.peek().equals(stack.pop())){
            minStack.pop();
        }
    }
    
    public int top() {
    	//returns top of stack
        return stack.peek();
    }
    
    public int getMin() {
    	//returns top of minstack which is the minimum value
        return minStack.peek();
    }
}

public class SplStack {
	public static void main(String args[]) {		
		MinStack mStack=new MinStack();
		mStack.push(10);
		mStack.push(20);
		mStack.push(5);
		mStack.push(17);
		mStack.push(26);
		mStack.push(78);
		mStack.pop();
		System.out.println(mStack.getMin());	//returns 5
	}
}
