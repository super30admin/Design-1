import java.util.Stack;
/*
 * Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() 
 * and an additional operation getMin() which should return minimum element from the SpecialStack. 
 * All these operations of SpecialStack must be O(1).
 */
public class MinStack {
	/*
	 * Insert a Pair in the stack which will contain Element and minimum element at any point of time.
	 */
	class Pair{
		int min, element;
		public Pair(int element, int min) {
			this.element= element;
			this.min = min;
		}
	}
	Stack<Pair>stack;
	/*
	 * Constructor
	 */
	public MinStack() {
		stack = new Stack<>();
	}
	/*
	 * Push element x onto stack.
	 */
	public void push(int x) {
		if(stack.isEmpty())
			stack.push(new Pair(x, x));
		else {
			Pair ele = stack.peek();
			//fetching current min of the stack
			//if current element is less than current min current element becomes min 
			int min = Math.min(ele.min, x);
			stack.push(new Pair(x, min));
		}
	}
	/*
	 * Removes the element on top of the stack.
	 */
	public void pop() {
		if(!stack.isEmpty()) 
			stack.pop();
		return;
	}
	/*
	 * Get the top element.
	 */
	public int top() {
		if(!stack.isEmpty()) {
			Pair ele = stack.peek();
			return ele.element;
		}
		else 
			return -1;
	}
	/*
	 * Retrieve the minimum element in the stack.
	 */
	public int getMin() {
		//fetch the minimum element at any point of time in O(1)
		//we can retrieve the pair from top of the stack. And min attribute of the Pair is the current minimum element.
		if(!stack.isEmpty()) {
			Pair ele = stack.peek();
			return ele.min;
		}
		else 
			return -1;
	}

	public static void main(String args[]) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}
//Time Complexity : Push-O(1), Pop-O(1), getMin-O(1), top-O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this : Nope