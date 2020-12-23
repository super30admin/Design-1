// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> st;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        st = new Stack<Integer>();
        minStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int x) {
        min = Math.min(min,x);
        st.push(x);
        minStack.push(min);
    }

    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
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
