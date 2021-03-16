/*
 *  Time Complexity: O(1) for all the functions push, pop, top and getMin.
 *  Space Complexity: O(N) where N is the max size of the stack.
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : Design the approach to hold the min element. 
 * 
 *  Explanation:
    *  Maintain a stack with all the elements, also maintain another stack which would hold the min element seen till that point. 
    *  Every time we add a new element we also update the minstack with the corresponding min value till then. 
    *  So if we pop any element we would also pop the top element from minstack. 
 */

import java.util.*;
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
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