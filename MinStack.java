/*
 * Approach:
 *  1. Maintain current minimum to keep track of minimum element of the stack.
 * 
 *  2. While pushing, compare the incoming element with current minimum
 *      2.1. If element <= current minimum, then
 *              push the prev minimum to stack and update the current minimum.
 *      2.2. else, push the element to stack 
 * 
 *  3. While popping, compare outgoing element with current minimum
 *      3.1 If outgoing element is same as current minimum, then
 *              pop again and get the prev minimum into current minimum.
 * 
 * 
 * Did this code successfully run on Leetcode : YES
 * 
 * Any problem you faced while coding this : NO
 * 
 * Time Complexity:
 *  push - O(1)
 *  pop - O(1)
 *  top - O(1) 
 *  getMin - O(1)
 * 
 * Space Complexity:
 *  O(n) - auxilary stack is used
 */

import java.util.Stack;

class MinStack {
    private int min;

    private Stack<Integer> st;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        st = new Stack();
        st.push(min);
    }

    public void push(int val) {
        if (val <= min) {
            st.push(min);
            min = val;
        }

        st.push(val);
    }

    public void pop() {
        if (st.pop() == min)
            min = st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}
