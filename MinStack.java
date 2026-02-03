class MinStack {

    private int[] stack;
    private int[] minStack;
    private int top;

    public MinStack() {
        stack = new int[30000];
        minStack = new int[30000];
        top = -1;
    }

    public void push(int val) {
        stack[++top] = val;

        if (top == 0) {
            minStack[top] = val;
        } else {
            minStack[top] = Math.min(val, minStack[top - 1]);
        }
    }

    public void pop() {
        minStack[top] = Integer.MAX_VALUE;
        stack[top] = Integer.MAX_VALUE;
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[top];
    }
}
