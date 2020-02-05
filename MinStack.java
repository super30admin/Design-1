// Time Complexity for getMin() operation is O(1), which is a constant time.
// Space Complexity for the stack is O(n), where n is the number of elements added in the stack
// The code ran successfully on leetcode
// I didn't face any issues.

/* In this java class I implemented to get a minimum value from the Stack data structure
I have used two Stacks, one stack to hole all the elements and other one to hold the
minimum value at the point of insertion in the other stack. 

While inserting a new element in the stack, I am comparing the last element from the minStack
and the new element to get the minimum value out of it. Then, the minimum value is inserted.

The pop function removes the top element from both the stacks.
The peek function retrieves the top element from the stack holding all the values. 


*/

import java.util.Stack;

class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int x) {
		stack.push(x);
		int min = Math.min(x, minStack.peek());
		minStack.push(min);
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		if (stack.isEmpty())
			return Integer.MAX_VALUE;

		return stack.peek();

	}

	public int getMin() {
		return minStack.peek();
	}

}
