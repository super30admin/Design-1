// Time Complexity : O(1) for push, pop, top and getMin
// Space Complexity : O(n) where n is the number of elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// This approach uses two stacks: 
// a primary stack to store all the elements and 
// a min stack to keep track of the minimum element at each level of the primary stack. 
// Whenever a new element is pushed onto the primary stack, 
// we compare it with the current minimum element (the top of the min stack) and
// push the smaller of the two onto the min stack.

import java.util.Stack;

class MinStack {
    Stack<Integer> primaryStack;
    Stack<Integer> minStack;
    public MinStack() {
        primaryStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        primaryStack.push(val);
        if(minStack.isEmpty() || val < minStack.peek()){
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        if(primaryStack.isEmpty()){
            return;
        }
        primaryStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return primaryStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
