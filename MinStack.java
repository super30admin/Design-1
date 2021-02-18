package com.hmoework;

import java.util.Stack;

class MinStack {

	Stack<Integer> stack;
	int minValue;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<Integer>();
		minValue = Integer.MAX_VALUE;
		stack.push(minValue);
	}

	public void push(int x) {
		if (x <= minValue) {
			stack.push(minValue);

			stack.push(x);

			minValue = x;
		} else {
			stack.push(x);
		}

	}

	public void pop() {
		 int popValue = stack.pop();
			if (popValue == minValue) {
				if (!stack.isEmpty()) {
					minValue = stack.pop();
				}
			}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minValue;
	}
}
