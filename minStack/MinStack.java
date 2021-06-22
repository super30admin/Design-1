// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
package minStack;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	/** initialize your data structure here. */
	public MinStack() {
		/*
		 * Stack 1 will contain the elements in order. Stack 2's top will contain the
		 * current minimum element;
		 */
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	/*
	 * Push to stack 1 If the value is less than minimum value, push value to stack
	 * 2
	 */
	public void push(int val) {
		stack1.push(val);
		if (stack2.isEmpty() || val <= stack2.peek()) {
			stack2.push(val);
		}
	}

	public void pop() {
		/*
		 * If the top element of stack1 is being removed, removed top element of stack 2
		 */
		if (stack2.peek().equals(stack1.peek())) {
			stack2.pop();
		}
		stack1.pop();
	}

	public int top() {
		return stack1.peek();
	}

	public int getMin() {
		return stack2.peek();
	}

	public static void main(String args[]) {
		MinStack stackObj = new MinStack();
		stackObj.push(5);
		stackObj.push(4);
		stackObj.push(5);
		System.out.println("Stack Top is " + stackObj.top());
		System.out.println("Min Value of stack is " + stackObj.getMin());
		stackObj.pop();
		stackObj.push(32);
		stackObj.push(1);
		System.out.println("Min Value of stack is " + stackObj.getMin());
		stackObj.push(6);
		stackObj.pop();
	}
}