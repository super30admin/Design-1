import java.util.*;

class MinStack{
	
	/*
	 * Creating a Pair class to hold current min value as well as the value on top of the stack
	 */
	
	class Pair {
		int val;
		int currMin;
		
		public Pair(int val, int currMin) {
			this.val = val;
			this.currMin = currMin;
		}
	}
	/*
	 * The stack data structure here will hold the pair of top element and current minimum value
	 */
	Stack<Pair> stack;
	int min;
	
	/*
	 * Initialization in constructor
	 */
	public MinStack() {
		stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}
	
	/*
	 * 	pushing the current value in stack. Comparing the current value with minimum 
	 * and updating it if current minimum is less.
	 */
	public void push(int val) {
		min = Math.min(val, min);
		stack.push(new Pair(val, min));
	}
		
	/*
	 * pops the Pair from stack
	 */
	public void pop() {
		stack.pop();
	}
		
	/* 
	 * returns minimum value in stack at any point of time
	 */
	public int getMin() {
		Pair pair = stack.peek();
		if(!stack.isEmpty())
			return pair.currMin;
		System.out.println("Stack is empty; returning -1");
		return -1;
	}
		
	/*
	 * returns the top element in stack which is the last pushed element
	 */
	public int top() {
		Pair pair = stack.peek();
		if(!stack.isEmpty()) {
			return pair.val;
		}
		System.out.println("Stack is empty; returning -1");
		return -1; //returns -1 if empty
	}
	
	/*
	 * Defining test cases in main
	 */
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		int curr = 0;
		ms.push(10);
		ms.push(4);
		curr = ms.getMin();
		System.out.println("Min val is:" + curr);
		ms.push(2);
		ms.push(1);
		ms.push(6);
		curr = ms.getMin();
		System.out.println("Min val is:" + curr);
		ms.pop();
		curr = ms.top();
		System.out.println("Min val is:" + curr);
		ms.pop();
		curr = ms.getMin();
		System.out.println("Min val is:" + curr);
		
	}
}

//Time Complexity : O(1) for all operations in MinStack class
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : No; failed for below input. Need to discuss.
//Any problem you faced while coding this : No

/* input:
 * ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
 */

/* Output:
 * [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483646]
 * 
 */

/* Expected Output:
 * [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
 */
 
