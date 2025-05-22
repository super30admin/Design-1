import java.util.Stack;

class MinStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> stMin = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            stMin.push(val);
        } else {
            st.push(val);
            int temp = Math.min(val, stMin.peek());
            stMin.push(temp);
        }
    }

    public void pop() {
        st.pop();
        stMin.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return stMin.peek();
    }
}

public class MinStackImpl {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Current Min: " + minStack.getMin()); // -3

        minStack.pop();

        System.out.println("Top after pop: " + minStack.top()); // 0
        System.out.println("Current Min after pop: " + minStack.getMin()); // -2
    }
}
