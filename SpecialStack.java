import java.util.Stack;

public class SpecialStack {
	int MAX = 1000;
	Stack<Integer> stack;
	Stack<Integer> min_Stack;

	public SpecialStack() {
		stack = new Stack<Integer>();
		min_Stack = new Stack<>();
	}

	public void push(int x) {
		 
		if(!isFull()) {
		stack.push(x);
		System.out.println("Element added: " + x);
		}
		if (min_Stack.isEmpty()) {
			min_Stack.push(x);
			return;
		} else {
			if (x <= min_Stack.peek())
				min_Stack.push(x);
		}
	}

	public void pop() {
		int popped = stack.pop();
		System.out.println("Element popped: " + popped); 
		if (!min_Stack.empty() && min_Stack.peek() == popped) {
			min_Stack.pop();
			
		}
	}

	public int getMin() {
		System.out.println("The minimum value is "+ min_Stack.peek()); 
		return min_Stack.peek();
	}

	public boolean isEmpty() {
		
		return stack.empty();
	}

	public boolean isFull() {
		
		return stack.size() == MAX - 1;
	}
}

////Driver code 
//public class Main 
//{ 
//    public static void main(String[] args) 
//    { 
//    	SpecialStack s = new SpecialStack(); 
//        s.push(3); 
//        s.push(5); 
//        s.getMin(); 
//        s.push(2); 
//        s.push(1); 
//        s.getMin(); 
//        s.pop(); 
//        s.getMin(); 
//        s.pop(); 
//       
//    } 
//}
