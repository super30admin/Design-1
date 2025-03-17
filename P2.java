// Time Complexity : O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

import java.util.*;

class MinStack {
    public Stack<Integer>stack;
    public Stack<Integer>minStack;
    public MinStack() {
        stack=  new Stack();
        minStack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()||val<=minStack.peek()){   //Add to minStack if it's empty or the value is <= current minimum.
            minStack.push(val);
        }
    }
    
    public void pop() {
        int temp = stack.pop();
        if(temp==minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
