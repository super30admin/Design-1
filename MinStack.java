// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack minStack;
    Stack stack;
    int smallest;

    public MinStack() {
        smallest = Integer.MAX_VALUE;
        minStack = new Stack();
        stack = new Stack();
        minStack.push(smallest);
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            smallest = x;
            stack.push(x);
            minStack.push(x);
            return;
        }
        if (x < smallest) {
            smallest = x;
            stack.push(x);
            minStack.push(smallest);

        } else {
            stack.push(x);
            minStack.push(smallest);
        }
    }

    public void pop() {

        if (minStack.isEmpty()) {
            System.out.println("Stack in UnderFlow");
            return;
        }
        if ((int) stack.peek() == (int) minStack.peek()) {
            stack.pop();
            minStack.pop();
            smallest = (int) minStack.peek();
        } else {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return (int) stack.peek();

    }

    public int getMin() {
        return (int) minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */