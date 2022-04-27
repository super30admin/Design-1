mport java.util.Stack;

public class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.size() == 0) {
			minStack.push(x);
		} else {
			minStack.push(x < minStack.peek() ? x : minStack.peek());
		}
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
	
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
	
		minStack.push(5);
		minStack.push(4);
		minStack.push(3);
		minStack.push(8);
		minStack.push(2);
		minStack.pop();
		
		System.out.println(minStack.getMin());  /*should return 3*/
	}
}
