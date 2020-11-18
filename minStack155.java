package nov162020;

import java.util.Stack;

public class minStack155 {

	/** initialize your data structure here. */
	Stack<Integer> s = new Stack<>();
	Stack<Integer> min = new Stack<>();

	minStack155() {

	}

	public void push(int x) {
		if (min.isEmpty() || x <= min.peek())
			min.push(x);
		s.push(x);
	}

	public void pop() {
		if (s.peek().equals(min.peek()))
			min.pop();
		s.pop();
	}

	public int top() {
		return s.peek();
	}

	public int getMin() {
		return min.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** initialize your data structure here. */

	}

	// Time Complexity : o(1)
	// Space Complexity : o(1)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : no

	// Your code here along with comments explaining your approach
	/*
	 * we are using two stack method approach here, as per the requirement of the
	 * question Methods pop, top and getMin operations will always be called on
	 * non-empty stacks.* / 1. first define two stack with type of integer 2. now in
	 * push operation we will check if min stack is empty and the data value that is
	 * x is less than equal to min peek value that is top value
	 *
	 * 2. similarly in pop operation check the equality if both the stack's peek
	 * value same or not us same than pop from min 3.to get min element we will
	 * simply use peek method to return top element and similarly for top method to
	 * return s peek
	 */

}
