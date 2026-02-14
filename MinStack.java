// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes


// Your code here along with comments explaining your approach
/*
Take a stack and also a min variable to keep track of minimum value. Whenever new input comes, we
first try to compare and check if its less than or equal to existing min value, if so, we store the
previous min in the stack and then the new input. Similarly, for pop, we make sure to check if we
are popping the min value, if so, we update the min variable with previous min value from stack.
 */
class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }

    public void pop() {
        if(st.pop() == min)
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */