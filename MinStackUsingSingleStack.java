package Day_2;

import java.util.Stack;

//Time Complexity : push O(1), pop - O(1), top O(1), min O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes

/*
* Your code here along with comments explaining your approach : 
* I have implemented Min Stack using single stack.
*/

public class MinStackUsingSingleStack {
	Stack<Integer> st = new Stack<>();
	int min;

	/** initialize your data structure here. */
	public MinStackUsingSingleStack() {
		min = Integer.MAX_VALUE;
	}

	public void push(int x) {
		if (x <= min) {
			st.push(min);
			min = x;
		}
		st.push(x);
	}

	public void pop() {
		int popped = st.pop();
		if (popped == min) {
			min = st.pop();
		}
	}

	public int top() {
		return st.peek();
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStackUsingSingleStack obj = new MinStackUsingSingleStack();
		obj.push(5);
		obj.push(6);
		obj.push(3);
		System.out.println(obj.getMin());
		obj.pop();
		int param_3 = obj.top();
		int param_4 = obj.getMin();
		System.out.println(param_3);
		System.out.println(param_4);
	}
}
