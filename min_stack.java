//Time: O(1)
//Space: O(n)

class MinStack {

    private Stack<Integer> st; //Space: O(n)
    private Stack<Integer> minStack; //Space: O(n)

    public MinStack() { //Time: O(1)
        st = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) { //Time: O(1)
        st.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() { //Time: O(1)
        if (st.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        st.pop();
    }

    public int top() {//Time: O(1)
        return st.peek();
    }

    public int getMin() { //Time: O(1)
        return minStack.peek();
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
