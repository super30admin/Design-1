import java.util.Stack;

public class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minSt = new Stack<>();

    public MinStack() {

    }

    public void push(Integer num) {
        if(minSt.isEmpty() || num <= minSt.peek() ) {
            minSt.push(num);
        }
        st.push(num);
    }

    public void pop() {
        if(st.peek() == minSt.peek()){
            minSt.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
