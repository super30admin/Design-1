// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Handling the case where we need to check that the stack is empty and return the min value


// Your code here along with comments explaining your approach
//We use stack for this.Using 2 stacks . One is the stack with all the values and the other is the stack holding the min values. The first value pushed will be as infinity so that we don't have to check if the stack is empty and when it is min value is infinity.
import java.util.Stack;

class MinStack {

    private int minValue;
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        this.minValue = Integer.MAX_VALUE;
        this.st = new Stack<Integer>();
        this.minSt = new Stack<Integer>();
    }

    public void push(int val) {
        st.push(val);
        minValue = Math.min(minValue, val);
        minSt.push(minValue);
    }

    public void pop() {
        st.pop();
        minSt.pop();
        minValue = minSt.peek();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minValue;
    }
}