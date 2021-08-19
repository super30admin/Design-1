// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    Stack<Integer> st;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE; // Initially the min value is inifinite
    }

    public void push(int val) {
        // While pushing, if the value is less than or equal to min, push the previous min and update min
        if(val <= min){
            st.push(min); // previous min
            min = val; // update min
        }
        st.push(val); // push the value
    }

    public void pop() {
        // While popping, if the element being popped is equal to min, perform another pop and update min
        if(st.pop() == min){
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */