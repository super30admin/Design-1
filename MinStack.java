import java.util.Stack;

public class MinStack {

	/** initialize your data structure here. */

	Stack<Integer> stack;

	int minimum = Integer.MAX_VALUE;

	public MinStack() {

		stack = new Stack();

	}

	public void push(int x) {

		if (x <= minimum) {

			stack.push(minimum);
			minimum = x;
		}

		stack.push(x);

	}

	public void pop() {
		if (stack.pop() == minimum)
			minimum = stack.pop();
	}

	public int top() {

		return stack.peek();

	}

	public int getMin() {

		return minimum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinStack minStack = new MinStack();

		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		minStack.top();
		minStack.pop();
		minStack.top();
	
		System.out.println(minStack.getMin());

	}

}
