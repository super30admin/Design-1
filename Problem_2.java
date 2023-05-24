// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes

//The minStack class uses two stacks to efficiently track the minimum element. 
//Pushing compares the current minimum and updates it, and popping removes both the element and 
//the minimum.

import java.util.*;
public class minStack {
	Stack <Integer> Stack = new Stack<Integer>();
    Stack <Integer> min_vals= new Stack<Integer>();
    
    public void push(int val) {
        if(min_vals.isEmpty() || val<=min_vals.peek()){
            min_vals.push(val);
        }
        Stack.push(val);

    }
    
    public void pop() {
    if(Stack.peek().equals(min_vals.peek())){
        min_vals.pop();

    }
    Stack.pop();
    }
    
    public int top() {
        return Stack.peek();
    }
    
    public int getMin() {
        return min_vals.peek();
    }

	public static void main(String[] args) throws Exception {
		Sample minStack = new Sample();

	    minStack.push(5);
	    minStack.push(2);
	    minStack.push(7);

	    System.out.println("Top element: " + minStack.top());  // Output: Top element: 7
	    System.out.println("Minimum element: " + minStack.getMin());  // Output: Minimum element: 2

	    minStack.pop();

	    System.out.println("Top element: " + minStack.top());  // Output: Top element: 2
	    System.out.println("Minimum element: " + minStack.getMin());  // Output: Minimum element: 2
	}
}