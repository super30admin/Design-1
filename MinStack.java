// Time Complexity : O(1) 
// Space Complexity : O(n), where n is the number of elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        //push val to minstack if it is empty or a new min is found.
        if (stack.isEmpty() || getMin() >= val)
            minStack.push(val);
        //push val to stack
        stack.push(val);
    }
    
    public void pop() {
        //if min is popped from the stack, it is also popped from the minStack, so the top of minStack reflects the correct min. 
        if(stack.pop() == getMin()) minStack.pop();
    }
    
    public int top() {
        //peek from the stack
        return stack.peek();
    }
    
    public int getMin() {
        //peek from the minStack
        return minStack.peek();
    }
}
