// Time Complexity : O(1) for all operations
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Used a int[] to store the val and the current minimum on 0 and 1 index respectively
 * whenever the min changes I will start push the val with the new min.
 */

import java.util.*;

public class MinStack {
    Stack<int[]> st;
    int minimum = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int currMin = val;
        if(!st.isEmpty()) {
            int[] top = st.peek();
            currMin = top[1];
            if(val < currMin) {
                currMin = val;
            }
        } 

        st.push(new int[]{val, currMin});
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
