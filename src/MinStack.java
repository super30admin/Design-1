// Time Complexity  : O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this    : No

// Your code here along with comments explaining your approach

class MinStack {

    Stack<Integer> st;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(min >= x) {
            st.push(min);
            min = x;
        }
        st.push(x);
    }

    public void pop() {
        int val = st.pop();
        if(val == min) {
            min = st.pop();
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
