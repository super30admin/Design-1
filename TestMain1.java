
public class TestMain1 {
	public static void main(String[] args) {
		MinStackUsingOneStack minStack = new MinStackUsingOneStack();
		minStack.push(512);
		minStack.push(-1024);
		minStack.push(-1024);
		minStack.push(512);
		
		//System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		  // return 0
		System.out.println(minStack.getMin()); // return -2
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();  
		System.out.println(minStack.getMin());
	}
}