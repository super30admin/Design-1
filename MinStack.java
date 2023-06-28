// Time Complexity :o(1)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this :no


//// Your code here along with comments explaining your approach
//1. create stack of integer
//2. initialize min value to integer.max
//3. push : compare if new value is less than the minvalue if yes push and set the min value to new value ELSE just push new value to stack
//4. pop: If the element to be popped is the current minimum, pop it along with the next element, which represents the previous minimum.
//5. peek the element

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private int minElement;

    /** Initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minElement = Integer.MAX_VALUE;
    }

    /** Pushes the element val onto the stack. */
    public void push(int val) {
        // If the new value is smaller than or equal to the current minimum,
        // push the current minimum onto the stack before updating the minimum.
        if (val <= minElement) {
            stack.push(minElement);
            minElement = val;
        }
        stack.push(val);
    }

    /** Removes the element on the top of the stack. */
    public void pop() {
        // If the element to be popped is the current minimum,
        // pop it along with the next element, which represents the previous minimum.
        if (stack.pop() == minElement) {
            minElement = stack.pop();
        }
    }

    /** Gets the top element of the stack. */
    public int top() {
        return stack.peek();
    }

    /** Retrieves the minimum element in the stack. */
    public int getMin() {
        return minElement;
    }
}

