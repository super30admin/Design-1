// Time Complexity : O(1) for all the operations
// Space Complexity : O(N) for pushing the elements into stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class MinStack {

    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }

    public void pop() {
        if (st.pop() == min) {
            min = st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
       return min;
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.push(-1);
        System.out.println(minStack.getMin());

    }
}
