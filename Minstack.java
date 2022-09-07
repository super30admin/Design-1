// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, when the stack is empty have a min pointing to something or push some value into the minst in the constructor

// Your code here along with comments explaining your approach

// Have 2 stacks 2nd one is for maintaining the minimum value. Push and Pop both.

class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minst;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        st = new Stack<>();
        minst = new Stack<>();
        minst.push(min);
    }

    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minst.push(min);
    }

    public void pop() {
        st.pop();
        minst.pop();
        min = minst.peek();

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}
