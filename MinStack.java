//Time complexity o(1) all operations
//Space complexity o(n) for 2 stacks

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack(){
        minStack.push(min);
    }

    public void push(int val) {
        stack.push(val);
        min = Math.min(min, val);
        minStack.push(min);
    }

    public void pop(){
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(5);
        m.push(5);
        m.push(10);
        m.pop();

    }
}
