
import java.util.Stack;
import java.util.*;

class MinStack1_155 {
	
	// we maintain two stacks
	// we store new_min in min_stack not all min for each element
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> min_stack = new Stack<>();
	//int min = Integer.MAX_VALUE;
	
	public void push(int key) {
		if(stack.isEmpty()) {
			stack.push(key);
			min_stack.push(key);	
		}
		else {
			if(key < min_stack.peek()) {
				min_stack.push(key);
			}
			stack.push(key);
		}
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int pop() {
		int popped = stack.pop();
		if(popped == min_stack.peek()) {
			min_stack.pop();
		}
		return popped;
	}
	
	public int getMin() {
		return min_stack.peek();
	}
}

class MinStack2_155 {
	
	// More work with variable and using the same stack to keep track of min
	
	Stack<Integer> stack = new Stack<>();
	int min;
	
	public void push(int key) {
		stack.push(key);
		
		if(stack.isEmpty()) {
			min = key;
		}
		else {
			if(key > min) {
				stack.push(min);
			}
			else {
				min = key;
			}
		}
		
	}
	
	public int pop() {
		int popped = stack.pop();
		if(popped == min) {
			min = stack.pop();
		}
		return popped;
	}
	
	public int top() {
		return stack.peek();
		
	}
	
	public int getMin() {
		return min;
	}
	
}


public class MinStack_155 {
	
	public static void main(String args[]) {
		MinStack1_155 ob = new MinStack1_155();
		MinStack2_155 ob1 = new MinStack2_155();

		ob.push(-2);
		ob.push(0);
		ob.push(-3);
		System.out.print(ob.getMin());
		ob.pop();
		System.out.println(ob.getMin());
		ob.top();

		ob1.push(-2);
		ob1.push(0);
		ob1.push(-3);
		System.out.print(ob1.getMin());
		ob1.pop();
		System.out.print(ob1.getMin());
		ob1.top();
	}
}
	
	



