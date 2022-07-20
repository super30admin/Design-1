import java.util.Objects;
import java.util.Stack;

public class MinStack {

    Stack<Integer> inputStack;
    Stack<Integer> minStack;

    public MinStack() {
        inputStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        inputStack.push(val);

        // If input value matches with the top of the stack (duplicate min value), still add it.
        // Otherwise, minStack will be empty but input stack will still hold the min value.
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int data = inputStack.peek();

        if(!inputStack.empty() && Objects.equals(data, minStack.peek())) {
            minStack.pop();
        }
        inputStack.pop();
    }

    public int top() {
        return inputStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println("obj.getMin() = " + obj.getMin());

        obj.pop();
        System.out.println("obj.top() = " + obj.top());

        System.out.println("obj.getMin() = " + obj.getMin());
        System.out.println("top = " + obj.top());
        System.out.println("min = " + obj.getMin());
    }
}
