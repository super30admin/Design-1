// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    // Using two stacks. One stack to regularly store values and the other to store the min values.
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min_vals = new Stack<Integer>();
    
    public void push(int x) {
        //push x into the stack only if it is empty or if x is lesser than the minimum value stored in  min_vals stack.
        if(min_vals.isEmpty() || x<=min_vals.peek()){
            min_vals.push(x);
        }
        //regular push operation to add x to the stack
        stack.push(x);
    }
    
    public void pop() {
        //if the value we are removing is the min value, then we have to remove from min_vals stack too.
        if(stack.peek().equals(min_vals.peek())){
            min_vals.pop();
        }
        //regular pop operation to remove from the stack
        stack.pop();
    }
    
    public int top() {
        //performing the peek operation to return the top value of stack
        return stack.peek();
    }
    
    public int getMin() {
        //performing the peek operation on th emin_vals stack to return the minimum value in stack.
        return min_vals.peek();
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

// Driver code 
class Main { 
    public static void main(String args[]) 
    { 
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());      // return -3
        minStack.pop();
        System.out.println(minStack.top());         // return 0
        System.out.println(minStack.getMin());      // return -2         
    } 
}