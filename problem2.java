public class problem2 {
    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (min >= val) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
