// Time Complexity : push(), pop(), top() , getMin()   -> O(1) for each element
// Space Complexity : O(n) where n is size of the stack and minStack (temporary stack used)
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : None
 */
import java.util.Stack;
class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> minStack;
	// Your code here along with comments explaining your approach
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();  // temporary stack to store the minimum element found till now
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || minStack.peek() >= x){
            minStack.push(x);    // If the new element x is lesser or equal than what it has already, push it
        }
        
    }
    
    public void pop() {
        int out = stack.pop();
        if(out == minStack.peek()){ // If the element getting removed = top of min stack, min stack loses its top element
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();   // top of minstack represents the min element found till now
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