import java.util.Stack;

public class SpecialStack {
	int capacity = 100;
	int minElement = 0;
	Stack<Integer> stack1 = new Stack<>();
	
	public boolean isEmpty() {
		if(stack1.size() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(stack1.size() == capacity) {
			return true;
		}
		return false;
	}
	
	public void push(int data) {
		if(stack1.size() == capacity) {
			System.out.println("Stack overflow");
		}else if(stack1.size() == 0) {
			minElement = data;
			stack1.push(data);
		}else {
			if(Integer.compare(data, stack1.peek()) == -1){
                stack1.push(2*data - minElement);
                minElement = data;
            }else{
                stack1.push(data);
            }
		}
	}
	
	public void pop() {
		if(stack1.size() == 0) {
			return;
		}
		int element = stack1.pop();
        if(element < minElement){
            minElement = 2*minElement - element;
        }
	}
	
	public int getMin() {
		return minElement;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecialStack myStack = new SpecialStack();
		myStack.push(-2);
		myStack.push(0);
		myStack.push(-1);
		System.out.println(myStack.getMin());
		myStack.pop();
		System.out.println(myStack.getMin());

	}

}
