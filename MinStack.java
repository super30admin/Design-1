import java.util.Stack;
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No as it was already discussed.

// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> minStack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {

        minStack = new Stack<>();
        min = Integer.MAX_VALUE;

    }

    public void push(int x) {

        if (x <= min) {
            minStack.push(min);
            minStack.push(x);
            min = x;

        } else {
            minStack.push(x);
        }

    }

    public void pop() {

        if (minStack.peek() == min) {
            minStack.pop();
            min = minStack.pop();
        } else {
            minStack.pop();
        }

    }

    public int top() {
        return minStack.peek();

    }

    public int getMin() {

        return min;

    }
}