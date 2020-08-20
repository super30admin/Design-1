//Time Complexity For push,pop,top,getMin O(1)
//space Complexity: O(n)

class MinStack {

    private Stack<Integer> st;
    private Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {

        if (x <= min) {
            st.push(min);
            min = x;
        }
        st.push(x);

    }

    public void pop() {

        int popped = st.pop();

        if (popped == min)
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
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */