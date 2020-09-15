// Time Complexity : O (n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
	int min = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
        	min = x;
        }
        if(x <= min) {
        	stack.push(min);
        	min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
    	int pop = stack.pop();
        
        if(pop == min) {
        	min = stack.pop();
        }
    }
    
    public int top() {
    	if(stack.isEmpty()) return -1;
        return stack.peek();        
    }
    
    public int getMin() {
        if(stack.isEmpty()) return -1;
        return min;        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */