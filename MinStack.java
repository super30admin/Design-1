package com.Aug2020;
//Time Complexity : O(1)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :

// how to make the solution work using one-stack only to avoid extra stack.
class MinStack {

	/** initialize your data structure here. */
	private Stack<Integer> s;

	private Stack<Integer> minStack;

	public MinStack() {
		s = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {

		s.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}

		
	}

	public void pop() {

		if (s.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		s.pop();

	}

	public int top() {

		return s.peek();
	}

	public int getMin() {

		return minStack.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
