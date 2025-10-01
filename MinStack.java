import java.util.Stack;

/**
 * This min stack implementation is space efficient.
 */
public class MinStack {

    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        // stack.push(min);
    }

    public void push(int val) {
        if (val <= min) { // handle duplicates
            stack.push(min); // push the previous min
            stack.push(val);
            min = val;
        } else stack.push(val);
    }

    void pop() {
        if (stack.isEmpty()) return;
        int val = stack.peek();
        if (val <= min) {
            stack.pop();
            min = stack.pop(); // pop the previous min
        } else stack.pop();
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return min;
    }
}
