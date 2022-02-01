// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (failed some test cases)
// Any problem you faced while coding this : 

import java.util.Stack;

class MinStack {

    // creating 2 stacks
    Stack<Integer> s;
    Stack<Integer> minStack;
    
    public MinStack() {
        s = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    // checking if value to push is less than top of min stack OR if min stack empty
    // if true then we have new minimum value and we push to min stack
    // else it is pushed to s as it is greater than current minimum value
    public void push(int val) {
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        }
        s.push(val);
    }
    
    // if top value of min stack equals top value of s
    // then top of min stack is not minimum so we pop
    // else pop element from s
    public void pop() {
        if (minStack.peek() == s.peek()) {
            minStack.pop();
        }
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    // topmost value must be minimum so peek and return
    public int getMin() {
        return minStack.peek();
    }
}
