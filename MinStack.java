import java.util.Stack;

class MinStack {

    Stack<Integer> st;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        st = new Stack<Integer>();
        st.push(min);
    }

    public void push(int val) {
        if (val <= min) {
            st.push(min);
            min = val;
            st.push(val);
        } else {
            st.push(val);
        }
    }

    public void pop() {
        if (st.peek() == min) {
            st.pop();
            min = st.pop();
        } else {
            st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */