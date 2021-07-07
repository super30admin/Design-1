import java.util.Stack;
// Time Complexity :  O(1) for all operations 

// Space Complexity : O(N) for storing stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 For getMin operation,we maintain a global variable to store currentMin.
 This variable will be upidated on every push and pop operation
*/

public class MinStack {

	int currentMin;
	Stack<Integer> stack;

	public MinStack() {
		currentMin = Integer.MAX_VALUE;
		stack = new Stack<>();
	}

	public void push(int ele) {
		if (ele < currentMin) {
			stack.push(currentMin);
			currentMin = ele;
		}
		stack.push(ele);

	}

	public void pop() {
		int topEle = stack.pop();
		if (topEle == currentMin) {
			currentMin = stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		System.out.println("Minimum is " + currentMin);
		return currentMin;
	}

	public static void main(String args[]) {
		MinStack stack = new MinStack();
		stack.push(30);
		stack.push(20);
		stack.push(10);
		stack.getMin();
		stack.push(5);
		stack.getMin();
		stack.pop();
		stack.getMin();
	}
}
