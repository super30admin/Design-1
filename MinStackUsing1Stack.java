import java.util.*;

public class MinStackUsing1Stack {

	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<>();
	
	public MinStackUsing1Stack() {
		
	}
	
	// logic to push two minimum values in the stack, old and new minimum
	public void push(int x) {
		if(x < min) {
			stack.push(min);
			
			min = x;
			// System.out.println("updated minimum value is: " + min);
		}
		stack.push(x);
		// System.out.println("Element added: " + x);
	}
	

	// so that if new min is updated,
	// we have old minimum value updated in the min variable.
	public int pop() {
		int popped = stack.pop();
		// System.out.println("Element popped: " + popped); 
		if(popped == min) {
			min = stack.pop();
		}
		return 0;
	}
	
	public int get_Min() {
		// System.out.println("The minimum value is "+ min); 
		return min;
	}
	
	public int top() {
		return stack.peek();
	}
	
//Driver code 
 public static void main(String[] args) 
    { 
	 MinStackUsing1Stack s = new MinStackUsing1Stack(); 
        s.push(3); 
        s.push(5); 
        s.get_Min(); 
        s.push(4); 
        s.push(2); 
        s.get_Min(); 
        s.pop(); 
        s.get_Min(); 
        s.pop(); 
       
    }
	
}
