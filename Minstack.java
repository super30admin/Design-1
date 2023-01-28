import java.util.Stack;

//Time Complexity : O(1)
//Space Complexity : O(n) as we are using two stack
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

//Your code here along with comments explaining your approach
//using 1:1 mapping for designing minstack, initial min is assigned to interger.max value 
//and push and pop equally in two stack to maintain proper min value   

class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;
	int min;

	public MinStack() {
		this.min = Integer.MAX_VALUE;
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
		minStack.push(min);
	}

	public void push(int val) {
		min = Math.min(val, min);
		stack.push(val);
		minStack.push(min);
	}

	public void pop() {
		stack.pop();
		minStack.pop();
		min = minStack.peek();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
