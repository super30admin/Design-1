//Min Stack
//Time Complexity: O(1)
//Space Complexity: O(n)

import java.util.Stack;

class MinStack {
    Stack<Integer> st = new Stack<>();
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        st.push(min);
    }

    public void push(int x) {
        if(x <= min){
            st.push(min);
            min = x;
        }
        st.push(x);
    }

    public void pop() {
        int x;
        x = st.pop();
        if(x == min)
            min = st.pop();
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */