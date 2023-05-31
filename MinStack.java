import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
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

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        System.out.println("null");
        minStack.push(-2);
        System.out.println("null");
        minStack.push(0);
        System.out.println("null");
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("null");
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

