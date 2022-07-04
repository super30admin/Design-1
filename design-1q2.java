//design-1q2 - minstack
//LC 155
// we will keep 2 stacks and every time a new element is inserted in the main stack we will compare with the min in min stack


class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    int min;
    public MinStack() {
        min = Integer.MAX_VALUE;
        st = new Stack<>();
        minSt = new Stack<>();
        minSt.push(min);
        
    }
    // Overall Time complexity - O(1)
    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minSt.push(min);
    }
    // Overall Time complexity - O(1)
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }
    // Overall Time complexity - O(1)
    public int top() {
        return st.peek();
    }
    // Overall Time complexity - O(1)
    public int getMin() {
        return minSt.peek();
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

