// Time Complexity : O(1), considering, push, pop, peek as the constant operations in the library
// Space Complexity : O(n), where are n is the max elements that are being pushed as we are using another stack to maintain min
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, earlier I was missing out in one of the test cases,
// after adding code from line 47-51 it was resolved.

import java.util.Stack;

class MinStack {

    Stack<Integer> minStack; // Contains the minimum element at any given point
    Stack<Integer> major; // Represents the current state of stack

    int min;

    private int size() {
        return major.size();
    }

    public MinStack() {
        minStack = new Stack<>();
        major = new Stack<>();
        min = Integer.MAX_VALUE; // To represent the minimum element
    }

    public void push(int val) {
        if(major.isEmpty()) {
            min = Integer.MAX_VALUE;
        }

        // If the current element is less than or equal to the min element, push in the min stack
        if(val <= min) {
            min = val;
            minStack.push(val);
        }

        // Push in the main stack
        major.push(val);
    }

    public void pop() {
        // Remove the element from minStack as well, when we are removing the min element from the main stack
        // So that the new min can be obtained from the minStack when asked
        if(min == major.peek()) {
            minStack.pop();
        }

        if(!minStack.isEmpty()){
            // Need to update the new min, because the in might have changed as we are popping out the elements from
            // minStack in the above conditions for certain cases.
            min = minStack.peek();
        }
        major.pop();
    }

    public int top() {
        return major.peek();
    }

    public int getMin() {
        if(!minStack.isEmpty()) {
            // Return the top element from minStack
            return minStack.peek();
        }
        // Though below will not happen as it's given in the question that there will be valid operations only
        return Integer.MAX_VALUE;
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