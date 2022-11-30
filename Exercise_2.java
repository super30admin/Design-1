// Design Min Stack
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// Create one primary stack and one min stack(which will keep track of the minimum, then previous minimum elements...)
// Declare a global min counter which will keep track of current min element. While poping out, previous min should be assign to min.
// If current element is less then min, then only push to minstack.

class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private int min;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        min = Integer.MAX_VALUE;
        minSt.push(min);
    }

    public void push(int val) {
        st.push(val);
        min = Math.min(min, val);
        minSt.push(min);
    }


    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }

    public int top() {
        return st.peek();
    }

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