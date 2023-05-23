// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

import java.util.*;
class MinStack {
    Stack<Integer> stk;//Create a stack to store the input and all the operations on it
    Stack<Integer> minStk;//Create a stack to store the min value reported in each iteration
    
    public MinStack() {
        stk = new Stack<>(); 
        minStk = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if (!stk.isEmpty() && val > minStk.peek())//checks if the stack is not empty and the new input value is greater than the previous min
        {
            min =  minStk.peek();// if true, assigns the old min value from the stack to the min variable
        }

        minStk.push(min);//min value gets pushed onto the stack
        stk.push(val);//new input gets pushed onto the stack

        
    }
    
    public void pop() {
       stk.pop();//Both will be popped
       minStk.pop();
    }
    
    public int top() {
        
        return stk.peek();
        
    }
    
    public int getMin() {
        
        return minStk.peek();
        
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