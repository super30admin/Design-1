// Time Complexity: O(1)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No problem while coding

import java.util.Stack;

class MyMinStack {
    int min;
    private Stack<Integer> st;

    public MyMinStack() {
        // Initilising min value & stack
        min = Integer.MAX_VALUE;
        st = new Stack<>();
    }

    public void push(int val) {
        // Check if min is bigger than val
        if (min >= val) {
            System.out.println("Min element is bigger than val so pushing min first: " + min);
            // min is bigger then push min underneath the value
            st.push(min);
            min = val;
        }
        System.out.println("Pushing Value: " + val);
        st.push(val);
    }

    public void pop() {
        // int val = st.pop();
        if (min == st.pop()) {
            // if min is poped element then pop the min as well from underneath
            min = st.pop();
        }
        System.out.println(" POPPED element: " + min);
    }

    public int top() {
        // returning peek element here
        System.out.println("Top element: " + st.peek());
        return st.peek();
    }

    public int getMin() {
        // returning min value
        System.out.println("Min element: " + min);
        return min;
    }
}

public class MinStack {
    public static void main(String[] args) {
        MyMinStack obj = new MyMinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.getMin();
        obj.pop();
        obj.top();
        obj.getMin();
    }
}
