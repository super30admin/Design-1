import java.util.Stack;

/* Using One Stack finding out the minimum*/
public class MinStackUsingOneStack {
	Integer min;
	Stack<Integer> mainStack;

	public MinStackUsingOneStack() {
		// TODO Auto-generated constructor stub

		mainStack = new Stack<Integer>();
		min = Integer.MAX_VALUE;
	}

	public void push(Integer x) {

		if (x <= min) {
			mainStack.push(min);
			min = x;
		}
		mainStack.push(x);
	}

	public void pop() {
		if (min == mainStack.pop()) {
			min = mainStack.pop();
		}

		// min=mainStack.peek();
	}

	public int top() {
		return mainStack.peek();
	}

	public int getMin() {
		return min;
	}
}
