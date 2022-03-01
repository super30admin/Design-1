import java.util.*;

class MinStack {

    Stack<Integer> st = new Stack();
    Stack<Integer> min_stack = new Stack();

    public void push(int val) {
        if (min_stack.isEmpty() || min_stack.peek() >= val) {
            min_stack.push(val);
        }
        st.push(val);
    }

    public void pop() {
        if (st.peek().equals(min_stack.peek())) {
            min_stack.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        obj.top();
        System.out.println(obj.getMin());
    }
}
