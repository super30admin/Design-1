/******************************************************************************
// Time Complexity : O(N)
// Space Complexity : O(1)
*******************************************************************************/
import java.io.*;
import java.util.*;

public class Main
{
   
	public static void main(String[] args) 
	{
	    Main program = new Main();
		Stack<Integer> mainStack = new Stack<Integer>();
		Stack<Integer> minStack = new Stack<Integer>();
	    program.Add_Element(2,mainStack,minStack);
	    program.Add_Element(0,mainStack,minStack);
	    program.Add_Element(3,mainStack,minStack);
	    System.out.println(program.getMin(mainStack,minStack));
	    int deletedElement = program.Delete_Element(mainStack,minStack);
	    System.out.println(deletedElement); 
	    System.out.println(program.getMin(mainStack,minStack));
	}
	void Add_Element(int val,Stack<Integer> mainStack,Stack<Integer> minStack)
	{
	    mainStack.push(val);
	    if(minStack.size() == 0 || val <= minStack.peek())
	       minStack.push(val);
	}
	
	
	int getMin(Stack<Integer> mainStack , Stack<Integer> minStack)
	{
	    if(minStack.size() == 0)
	    {
	        return -1;
	    }
	   int element = minStack.peek();
	   return element;
	}
	int Delete_Element(Stack<Integer> mainStack , Stack<Integer> minStack)
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
