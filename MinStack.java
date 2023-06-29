import java.util.*;

public class MinStack {

    /** initialize your data structure here. */
    int min;
    Stack<Integer> minStack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        minStack = new Stack<>();

    }

    public void push(int val) {
        if (val <= min) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }

    public void pop() {
        if (minStack.pop() == min) {
            min = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }
}