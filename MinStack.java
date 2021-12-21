
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class MinStack {
    //Main Stack
    Stack<Integer> stack = new Stack();
    //Stack to maintain minimum
    Stack<Integer> minStack = new Stack();

    public void push(int val) {
        //If min stack is empty or the last inserted value is less than the new value, insert into min stack
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
        //Push value in main stack as well
        stack.push(val);
    }

    public void pop() {
        //If last main stack value is equal to the last minimum stack value, remove both
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        //return the last element
        return stack.peek();
    }

    public int getMin() {
        //return the minimum element from minStack
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
