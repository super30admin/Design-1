import java.util.Stack;

public class MinStack {
	
	//Comment
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	
	public void push(int x){
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()){
			minStack.push(x);
		}
	}
	
	public void pop(){
		
		if (minStack.peek() == stack.peek()){
			minStack.pop();
		}
		stack.pop();
	}
	
	public int top(){
		return stack.peek();
	}
	
	public int min(){
		return minStack.peek();
	}
	
	public static void main(String args[]){
		
		MinStack obj = new MinStack();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		
		int top = obj.top();
		int min = obj.min();
		
		System.out.print("Top Element is " + top);
		System.out.print("Min Element is " + min);
		
	}
	

}
