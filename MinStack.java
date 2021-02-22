// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;

class MinStack {
	public Stack<Integer> stack ;
    public Stack<Integer> minStack ;
    
    /** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<Integer>();
    	minStack = new Stack<Integer>();
    }      
    
    public void push(int x) {
        if(stack.empty()){
            stack.push(x);
            minStack.push(x);
        }
        else{
            stack.push(x);
            minStack.push(Math.min(minStack.peek(),x));
        }       
    }
    
    public void pop() {
    	if (stack.peek() == minStack.peek())
             minStack.pop();
        stack.pop();          
    }   
    
    public int top() {
        return stack.peek();
    }
       
    public int getMin() {
        if(stack.empty()){
            return -1;
        }
        return minStack.peek();
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