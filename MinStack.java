// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;

public class MinStack {
    int min;
    Stack<Integer> one;
    Stack<Integer> minStack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        one = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }

    public void push(int val) {
        min = Math.min(min, val);
        one.push(val);
        minStack.push(min);
    }

    public void pop() {
        one.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return one.peek();
    }

    public int getMin() {
        return min;
    }
}
