import java.util.Stack;

class MinStack {

    Stack<Integer> storageStack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        storageStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        storageStack.push(val);
        min = Math.min(min, val);
        minStack.push(min);
    }

    public void pop() {
        storageStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return storageStack.peek();
    }

    public int getMin() {
        return  minStack.peek();
    }
}