import java.util.Stack;

public class QueueUsingStack {
	
	private Stack<Integer> stack1 ;
	private Stack<Integer> stack2 ;
	
	public QueueUsingStack(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void push(int x) {
		stack1.push(x);
	}
	
	public boolean empty(){
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	public int pop(){
		if(stack2.isEmpty()){
			while (!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	
	public int peek(){
		if(stack2.isEmpty()){
			while (!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	public static void main(String[] args) {
		QueueUsingStack queueUsingStack = new QueueUsingStack();
		queueUsingStack.push(1);
		queueUsingStack.push(2);
		System.out.print(queueUsingStack.peek());
		System.out.print(queueUsingStack.pop());
		System.out.print(queueUsingStack.empty());
	}
}
