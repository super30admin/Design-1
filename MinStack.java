// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced some syntactical errors 

import java.util.Stack;
class MinStack {

    /* initialization of data structure */
    Stack<Integer> stack = new Stack();
    Stack<Integer> splStack = new Stack(); // Second stack that stores the minimum value at the top 
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(splStack.isEmpty() || val <= splStack.peek())  
            splStack.push(val);
    }
    
    public void pop() {
        if(stack.isEmpty()) 
            System.out.println("Stack Underflow");
        else {
            if(splStack.peek().equals(stack.peek())) 
                splStack.pop();
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return splStack.peek();
    }
}

