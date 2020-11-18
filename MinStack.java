import java.util.Stack;
class MinStack {

    private Stack<Integer> stack = new Stack<Integer>();
private Stack<Integer> minStack = new Stack<Integer>();

public void push(int x) {
	stack.push(x);
	if (minStack.size() != 0) {
		int min = minStack.peek();
		if (x <= min) {
			minStack.push(x);
		}
	} else {
		minStack.push(x);
	}
}

public void pop() {
	int x = stack.pop();
	if (minStack.size() != 0) {
		if (x == minStack.peek()) {
			minStack.pop();
		}
	}
}

public int top() {
	return stack.peek();
}

public int getMin() {
    return minStack.peek();
}
}