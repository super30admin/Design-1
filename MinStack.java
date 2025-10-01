import java.util.Stack;

/**
 * 
 */

/**
 * @author Aditya Sinha
 *
 */
// we will follow 2 stack approach, one for storing original value, another for maintaining min value
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
public class MinStack {
	Stack<Integer> origStack; // stores original value to be inserted
	Stack<Integer> minStack; // stores minimum at the moment
	int min;
	
    public MinStack() {
    	this.origStack = new Stack<Integer>();
    	this.minStack = new Stack<Integer>();
    	min = Integer.MAX_VALUE;
    	minStack.push(min);
    }
    
    public void push(int val) { // time complexity - O(1)
    	min = Math.min(val, min);
    	origStack.push(val);
    	minStack.push(min);
    }
    
    public void pop() { // time complexity - O(1)
    	origStack.pop();
    	minStack.pop();
    	min = minStack.peek();
    }
    
    public int top() { // time complexity - O(1)
        return origStack.peek();
    }
    
    public int getMin() { // time complexity - O(1)
        return min;
    }
}

//Driver code 
class MainMinStack { 
public static void main(String args[]) 
{ 
	MinStack obj = new MinStack();
	 obj.push(-2);
	 obj.push(0);
	 obj.push(-3);
	 System.out.println("1st Min value MinStack - " + obj.getMin());
	 obj.pop();
	 System.out.println("Top MinStack - " + obj.top());
	 System.out.println("2nd Min value MinStack - " + obj.getMin());
   
} 
}
