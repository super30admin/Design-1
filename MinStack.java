
// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;

class MinStack {

	/** initialize your data structure here. */
	Stack<Integer> stack = new Stack(); // stack keeps track of all values
	Stack<Integer> min = new Stack(); // min keeps track of only minimumm values

	public void push(int x) {
		if (min.isEmpty() || x <= min.peek()) { // if min is empty or if current value is lesser than top of min, then the
																// current value is pushed onto the stack
			min.push(x);
		}
		stack.push(x); // Later the current value is pushed onto stack
	}

	public void pop() {
		/*
		 * If Top value of min and stack are equal then top of min is popped. After
		 * exiting from the if statement top value of stack is popped.
		 */
		if (stack.peek().equals(min.peek())) {
			min.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek(); // top value of stack is returned
	}

	public int getMin() {
		return min.peek(); // top value of min is returned
	}
}
