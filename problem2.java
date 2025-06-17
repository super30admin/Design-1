// Time Complexity : O(1) for push, pop, top and getMin operations
// Space Complexity : O(n) for the two stacks used to store the elements and the minimums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// My approach was to use two stacks, one for the actual elements and another for the minimums.
// So basically, it will work like a map - add the element in stack, right at the same time, keep the push minimum element on top of other stack.
// When we pop an element, we also pop the minimum element from the second stack - so every time we call getMin, it will return the top of the second stack which is the minimum element.

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {
        this.minStack = new Stack<>();
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(!minStack.isEmpty() && val>this.minStack.peek()) this.minStack.push(this.minStack.peek());
        else this.minStack.push(val);
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
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