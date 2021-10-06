import java.util.*;

public class MinStack {
    private Stack<int[]> stack = new Stack<int[]>();

    public MinStack() {
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[] { x, x });
            return;
        }
        int currentMin = stack.peek()[1];
        stack.push(new int[] { x, Math.min(x, currentMin) });
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

}
