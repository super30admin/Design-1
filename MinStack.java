
/*
Time: Push O(1), Pop O(1), Top O(1), getMin O(1)
Space: O(2*n) = O(n) - worse case, when elements coming in decreasing order
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }

        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();

    }

    public int top() {

        return stack.peek();

    }

    public int getMin() {

        return minStack.peek();
    }

}
