// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, but need to learn about optimal solution approach.


// Your code here along with comments explaining your approach

import java.util.Stack;

public class Design2 {
	
	public Design2() {
		
	}
    
	Stack<Integer> stk = new Stack<>();
    Stack<Integer> min = new Stack<>();
    
    public void push(int x) {
                
        stk.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }

    }
    
    public void pop() {
        if(stk.isEmpty()) {
        	return;
        }
        int x = stk.peek();
        
        if(x==min.peek()) {
        	min.pop();
        }       
        stk.pop(); 
    }
    
    public int top() {
        if(stk.isEmpty()) {
        	return -1;
        }      
    	return stk.peek();
    }
    
    public int getMin() {
        if(min.isEmpty()) {
        	return -1;
        }      
    	return min.peek();
    
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Design2 minStack = new Design2();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top();    // return 0
		minStack.getMin(); // return -2
	}

}
