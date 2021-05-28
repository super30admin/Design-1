public class StackWithMin extends Stack<Integer>
{
	Stack<Integer> s2;
	public StackWithMin(){
		s2=new Stack<Integer>();
	}
	public void push(int value)
	{
		if(value<=min()) { s2.push(value);}
		super.push(value);
	}
	public Integer pop()
	{
		int value=super.pop();
		if(value==min())
		{
			s2.pop();
		}	
		return value;

	}
	public int min()
	{
		if(s.isEmpty()) return Integer.MAX_VALUE;
		else{ return s2.peek();}
	}
}