
import java.lang.*;
import java.util.*;
public class Queue {

	Stack<Integer> st1 = new Stack();
	Stack<Integer> st2 = new Stack();
	
	public void push(int val) {
		//O(n)
		while(!st1.isEmpty()) {
			int value = st1.pop();
			st2.push(value);
		}
		st1.push(val);
		while(!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		
	}
	public int pop() {
		//O(1)
		if(!st1.isEmpty())
			return st1.pop();
		return -1;
	}
	public int peek() {
		//O(1)
		if(!st1.isEmpty())
			return st1.peek();
		return -1;
	}
	
	public boolean isEmpty() {
		return st1.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.push(10);
		q.push(2);
		q.push(12);
		q.push(100);
		System.out.println("Item deleted from the queue: "+q.pop());
		System.out.println("The first element in the queue: "+q.peek());
		System.out.println("Item deleted from the queue: "+q.pop());
		System.out.println("Is the Queue empty: "+q.isEmpty());

	}

}
