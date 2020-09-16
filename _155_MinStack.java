package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _155_MinStack {
	
	// space complexity O(n)
		// Time complexity 
		//push , getmin and top, pop() and peek() - O(1)
	
	class MinStack {

	    /** initialize your data structure here. */
	    
	    Stack<Integer> stack ;
	    int min = 0;
	    
	    public MinStack() {
	        stack = new Stack<>();
	        min = Integer.MAX_VALUE;
	    }
	    
	    public void push(int x) {
	        if(x <= min){
	            stack.push(min);
	            min = x;
	        }
	        stack.push(x);
	    }
	    
	    public void pop() {
	        if(min == stack.pop()){
	            min = stack.pop();
	        }
	    }
	    
	    public int top() {
	        return stack.peek();
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
	
	// below is also one approach which uses the formulae 2*y-minEle
	
	// space complexity O(n)
			// Time complexity 
			//push , getmin and top, pop() and peek() - O(1)

	/*public _155_MinStack() {

	}
	
	Long minEle = -1l;

	Stack<Long> s = new Stack<>();

	public void push(int x) {
		long y = x;

		if(s.isEmpty()) {
			minEle = y;
			s.push(y);
		}
		else {
			if(x > minEle) {
				s.push(y);
			}
			else {
				s.push(2*y-minEle);
				minEle =y;
			}
		}
	}

	public void pop() {
		if(!s.isEmpty()) {
			long temp = s.pop();
			if(temp < minEle) {
				minEle = 2*minEle - temp;
			}
		}
	}

	public int top() {
		return Long.valueOf(s.peek()<minEle?minEle:s.peek()).intValue();
	}

	public int getMin() {
		return Long.valueOf(minEle).intValue();
	}*/

}
