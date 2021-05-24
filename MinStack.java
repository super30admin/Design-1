package S30.Design1;

import java.util.Stack;
/**
 * @author Vishal Puri
 * // Time Complexity : All operations are in O(1)
 * // Space Complexity : Worst case stack size will be equal number of push operations. So O(n) for n push operations.
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        int temp = stack.pop();
        if(temp==minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
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
