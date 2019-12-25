import java.util.Stack;

public class minimumElementUsingOneStack {
		/** initialize your data structure here. */
		Stack<Integer> st = new Stack<>();
		int min = Integer.MAX_VALUE;

		public minimumElementUsingOneStack() {
		}

		public void push(int x) {
			if (x <= min) {
				st.push(min);
				min = x;
			}
			st.push(x);
		}
		public void pop() {
			if(st.pop() == min) {
			min = st.pop();
			}
		}

		public int top() {
			return st.peek();
		}

		public int getMin() {
			return min;
		}

		public static void main(String args[]) {
			MinimumElementUsingTwoStack minimumElementUsingOneStack = new MinimumElementUsingTwoStack();
			minimumElementUsingOneStack.push(-2);
			minimumElementUsingOneStack.push(0);
			minimumElementUsingOneStack.push(-3);
			minimumElementUsingOneStack.getMin(); // --> Returns -3.
			minimumElementUsingOneStack.pop();
			minimumElementUsingOneStack.top(); // --> Returns 0.
			minimumElementUsingOneStack.getMin(); // --> Returns -2.
		}

	}
