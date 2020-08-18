/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks.

 */

package com.s30.edu.design1;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack; // Stack to keep track of regular elements
    Stack<Integer> min_elements; // Stack to keep track of minimum elements
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min_elements = new Stack<>();
    }
    
    public void push(int x) {
    	// Push the minimum elements in 2nd stack as well
        if(min_elements.isEmpty() || x <= min_elements.peek()){ 
            min_elements.push(x);
        }
        stack.push(x); // Push regular and minimum elements both
    }
    
    public void pop() {
        if(stack.peek().equals(min_elements.peek())){ // If top element of regular stack matches min_stack, pop from 2nd stack as well
            min_elements.pop();
        }
        stack.pop(); // Pop from regular stack
    }
    
    // Get the top element
    public int top() {
        return stack.peek();
        
    }
    
    // Get the minimum element
    public int getMin() {
        return min_elements.peek();
        
    }
    
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
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
