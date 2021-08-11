import java.util.Stack;

// Time Complexity :O(1) costly push operations, but pop, getMIN is always o(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : considered 2 stacks, then came up with creating an inner class


// Your code here along with comments explaining your approach

// MinStack code 
/* 
  Approach:
  
  1) created an extra class containing the current min val and the existing value
  2) thus when i push, i need to check if the stack is empty or not. if empty then i directly push the value else i compare the value with min val and then push
  3) pop can be null operation 
  4) peek will have current value, min value
  5) if we return top we just return the value
  6) if we return getMin(), we just return the minValue


*/


class MinStack {

    class StackNode{
        
        int value;
        int minVal;
        
        public StackNode(int value, int minVal)
        {
            this.value=value;
            this.minVal = minVal;
        }
    }
    
     Stack<StackNode> stack;
    
    
    /** initialize your data structure here. */
    public MinStack() {
        
     stack = new Stack();
        
        
        
    }
    
    public void push(int val) {
        
       if(stack.isEmpty())
       {
           stack.push(new StackNode(val,val));
       }
        else
        {
            int min = Math.min(stack.peek().minVal,val);
            stack.push(new StackNode(val,min));
        }
    }
    
    public void pop() {
       
       stack.pop();
        
    }
    
    public int top() {
       
        if(!stack.isEmpty())
      {
        StackNode poll = stack.peek();
        
            return poll.value;
        
      } 
        
      return -1;  
    }
    
    public int getMin() {
        
      if(!stack.isEmpty())
      {
        StackNode poll = stack.peek();
        
            return poll.minVal;
        
      } 
        
      return -1;  
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */