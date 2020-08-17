import java.util.*;
import java.lang.*;

public class splStack {
	Stack<Integer> st = new Stack();
	Stack<Integer> minst = new Stack();
	static int size =0;
	int cnt=0;
	
	public boolean isFull() {
		if(size<=cnt)
			{
				return true;
			}
		return false;
			
	}
	public void push(int value) {
		if(minst.isEmpty())
		{
			minst.push(value);
		}
	
		if(!st.isEmpty() && value<st.peek())
		{
			minst.push(value);
		}
		if(cnt<=size)
		{	
			st.push(value);
			cnt++;
		}

	}
	public int pop() {
		int val = 0;
		if(st.peek()==minst.peek())
			{
				val =  minst.pop();
				return val;
			}
		return st.pop();
	}
	public boolean isEmpty() {
		if(st==null) {
			return true;
		}
		return false;
	}
	

	
	public int getMin() {
		if(!minst.isEmpty())
			return minst.pop();
		return 0;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		splStack minstack = new splStack();
		minstack.push(10);
		minstack.push(20);
		minstack.push(-5);
		minstack.push(1);
		System.out.println(": Item has been deleted"+ minstack.pop());
		System.out.println("the stack is Full if true: "+minstack.isFull());
		System.out.println("Min element in the stack: "+minstack.getMin());	
	}

}
