import java.util.AbstractMap;
import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

/**
 * Stored a Pair of element and min in the Stack so that I have min at every index
 */
class MinStack {

    private Stack<AbstractMap.SimpleEntry<Integer, Integer>> st;

    public MinStack() {
        this.st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new AbstractMap.SimpleEntry<Integer, Integer>(val, val));
        } else {
            int newMin = Math.min(st.peek().getValue(), val);
            st.push(new AbstractMap.SimpleEntry<Integer, Integer>(val, newMin));
        }

    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().getKey();
    }

    public int getMin() {
        if (st.isEmpty()) return Integer.MAX_VALUE;
        return st.peek().getValue();
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