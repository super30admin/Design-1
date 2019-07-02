import java.util.Stack;

public class MinSt {

	int min = Integer.MAX_VALUE;
	Stack<Integer> st = new Stack<>();
	Stack<Integer> minSt = new Stack<>();
	
	MinSt()
	{
		minSt.push(min);
	}
 	
	void push(int x)
	{
		st.push(x);
		if(x<min)
		{
			min = x;
		}		
	}
	
	void pop()
	{
		st.pop();
		minSt.pop();
		
	}
	
	int getMin()
	{
		return min;
	}
	
	public static void main(String args[])
	{
		MinSt obj = new MinSt();
		obj.push(5);
		obj.push(-3);
		obj.push(-1);
		obj.push(0);
		obj.pop();
		System.out.println("Min element: "+obj.getMin());
	}
}
