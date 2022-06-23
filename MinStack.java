//Time Complexity : push, pop, getmin, top- O(1) constant time
//Space Complexity : O(n), n is size of stack s
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : not on leetcode but on VS code while including main

//Your code here along with comments explaining your approach

/*Approach 2- using single stack instead of 2 stacks. We will perform 2 push operations for each value. If value is less than min.
Then first we will push the min and then value. If value is greater than min. Then just push value means push operation will be for 1 time.
while popping also, if min value as well as s.peek() is same then 2 times oppping will happen otherwise 1 time. and then after popping we will update the min
*/

import java.util.*;
public class MinStack {

	static Stack<Integer> s;
	static int min;

	 public static void MinStack() {
	     s = new Stack<>();
	     min = Integer.MAX_VALUE;
	 }

	 public static void push(int val) {
	     if (val <= min) {
	         s.push(min); // pushing old minimum
	         min = val; // updating min value with current value
	     }

	     s.push(val); // if value is greater than min value then simply push it into the stack s

	 }

	 public static void pop() {
	     if (min == s.pop())// 1st popping
	     {
	         // if same then 2nd popping
	         min = s.pop(); // and initializing the min value
	     }

	 }

	 public static int top() {
	     return s.peek(); // peek returns topmost element in stack and return NULL if stack is empty
	 }

	 public static int getMin() {
	     return min;
	 }

	public static void main(String[] args) {
		MinStack();
		Scanner inpObj = new Scanner(System.in); 
	    do
    	{
	    	System.out.println("Enter the text for calling funcntions and Q/q to exit \n");
	    	String text = inpObj.nextLine(); 
	    	if(text.equals("Q") || text.equals("q"))
	    	{
	    		break;
	    	}
	    	if(text.equals("push"))
	    	{
	    		System.out.println("Please enter the integer element you want to push into stack");
	    		Scanner sc= new Scanner(System.in); 
	    		int num=sc.nextInt();
	    		push(num);
	    	}
	    	if(text.equals("pop"))
	    	{
	    		pop();
	    	}
	    	if(text.equals("top"))
	    	{
	    		top();
	    	}
	    	if(text.equals("getMin"))
	    	{
	    		System.out.println("The min element in Stack is: " + getMin());
	    	}
	    	
    	}	while(true);
	 }
	}


