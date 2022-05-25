/******************************************************************************
// Time Complexity : O(N)
// Space Complexity : O(1)
*******************************************************************************/
import java.io.*;
import java.util.*;

public class Main
{
    Stack<Integer> mainStack;
	Stack<Integer> minStack;
    Main()
    {
       mainStack = new Stack<Integer>();
	   minStack = new Stack<Integer>();
    }
	public static void main(String[] args) 
	{
	    Main program = new Main();
		
	    program.Add_Element(2);
	    program.Add_Element(0);
	    program.Add_Element(3);
	    System.out.println(program.getMin());
	    int deletedElement = program.Delete_Element();
	    System.out.println(deletedElement); 
	    System.out.println(program.getMin());
	}
	void Add_Element(int val)
	{
	    mainStack.push(val);
	    if(minStack.size() == 0 || val <= minStack.peek())
	       minStack.push(val);
	}
	
	
	int getMin()
	{
	    if(minStack.size() == 0)
	    {
	        return -1;
	    }
	   int element = minStack.peek();
	   return element;
	}
	int Delete_Element()
	{
	    if(mainStack.size() == 0)
	    {
	        return -1;
	    }
	    int result =mainStack.peek();
	    mainStack.pop();
	    if(minStack.peek() == result)
	    {
	        minStack.pop();
	    }
	    return result;
	}
}
