import java.util.*;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class MinStack {
    private Stack<Integer> stk;
    private int min;

    public MinStack() {
        stk = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        // check if value is less than min
        if (val <= min) {
            // if yes, push the previous min to stack and update the new min
            stk.push(min);
            min = val;
        }
        // push the value to stack directly when min is not updated, else push the value
        // after the previous min
        stk.push(val);
    }

    public void pop() {
        // check if the element is the min
        if (min == stk.pop()) {
            // then pop the next element and update the min
            min = stk.pop();
        }
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return min;
    }
}
