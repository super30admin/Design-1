// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Approach is to use double hashing to avoid collisions. Implementing using 2D boolean array.
// Time Complexity : O(1) for add, remove and contains operations.
// Space Complexity : O(n) where n is the number of unique keys added to the Hash

import java.util.Stack;

// Implementing min stack using 2 stacks. One stack to keep track of all elements and other to keep track of minimum elements.
// Time Complexity : O(1) for push, pop, top and getMin operations.
// Space Complexity : O(n) where n is the number of elements in the stack.
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> mStack;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.mStack = new Stack<>();
        min = Integer.MAX_VALUE;
        mStack.push(min);
    }

    public void push(int val) {
        if (val < min) {
            min = val;
        }
        stack.push(val);
        mStack.push(min);
    }

    public void pop() {
        stack.pop();
        mStack.pop();
        min = mStack.peek();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

 class MinStackTest {
        public static void main(String[] args) {

            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin(); // return -3
            minStack.pop();
            minStack.top();    // return 0
            minStack.getMin(); // return -2

        }
}