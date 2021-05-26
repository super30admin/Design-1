package Design1;

import java.util.Stack;

public class problem2_minStack {
    Stack<Integer> stack;
    Stack<Integer> minVals;

    /** initialize your data structure here. */
    public problem2_minStack() {
        stack = new Stack<>();
        minVals = new Stack<>();
    }

    public void push(int val) {
        if(minVals.isEmpty() || val <= minVals.peek()) minVals.push(val);
        stack.push(val);
    }

    public void pop() {
        if(stack.peek().equals(minVals.peek())) minVals.peek();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVals.peek();
    }

    public static void main(String[] args) {

    }
}
