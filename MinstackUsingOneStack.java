import java.util.Stack;

//Time Complexity : O(1)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

//Your code here along with comments explaining your approach
//using 1:1 mapping for designing minstack, initial min is assigned to interger.max value    

class MinstackUsingOneStack {

	Stack<Integer> stack;
	int min;

	public MinstackUsingOneStack() {
		this.min = Integer.MAX_VALUE;
		this.stack = new Stack<>();
	}

	public void push(int val) {
		if (min >= val) {
			stack.push(min);
		}
		stack.push(val);
	}

	public void pop() {
		if (min == stack.pop()) {
			stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
