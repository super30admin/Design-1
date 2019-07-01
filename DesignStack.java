import java.util.*;
class DesignStack{
	// Logic to implement this problem was referenced from geeks for geeks
	//Added isEmpty function
	//Couldn't understand how to implement isFull() function
	
	
	Stack<Integer> stack;
	int minimum;
	
	//Constructor for initializing stack variable
	DesignStack(){
		stack = new Stack<Integer>();
	}
	
	//Function to push value into stack with maintaining minimum element of the stack
	void push(Integer val) {
		if(stack.isEmpty()) {
			stack.push(val);
			minimum = val;
			System.out.println(val + " has been pushed");
			return;
		}
		
		if(val < minimum) {
			stack.push(2*val - minimum);
			minimum = val;
		}
		else {
			stack.push(val);
		}
		System.out.println(val + " has been pushed");
	}
	
	//Function to remove value from stack maintaining minimum in the stack
	void pop() {
		
		if(isEmpty()) {
			System.out.println("Stack is Empty, Insert an Element first");
			return;
		}
		Integer top = stack.pop();
		if(top < minimum) {
			System.out.println(minimum + " was the top value in stack");
			minimum = 2*minimum - top;
		}
		else {
			System.out.println(top + " was the top value in stack");
		}
	}
	
	//Function to print top element without deleting it from stack
	void peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty, Insert an Element first");
			return;
		}
		Integer top = stack.peek();
		if(top<minimum) {
			System.out.println(minimum + " is the top value");
		}
		else {
			System.out.println(top + " is the top value");
		}
	}
	
	//Function to get minimum value from the stack
	void getMin() {
		if(isEmpty()) {
			System.out.println("Stack is Empty, Insert an Element first");
			return;
		}
		else {
			System.out.println(minimum + " is the minimum value in stack");
			
		}
	}
	
	//Function that will return true or false based on stack is empty or full
	boolean isEmpty() {
		if(stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating obj of class DesginStack
		DesignStack obj = new DesignStack();
		obj.push(5);
		obj.push(4);
		obj.push(3);
		obj.pop();
		obj.getMin();
		obj.peek();
		obj.push(2);
		obj.push(1);
		obj.pop();
		obj.pop();
		obj.getMin();
		obj.peek();
		obj.pop();
		obj.pop();
		obj.pop();
	}

}
