import java.util.Stack;

/**
 * Approach: Using a single stack to store the previous minimum along with the value whenever a new minimum is encountered.
 * If the new value is less than or equal to the current minimum, first push the current minimum, then push the new value, and update min to the new value.
 * Otherwise, simply push the value onto the stack.
 * When popping, if the popped value is equal to min, pop the next value as well (which stores the previous minimum) and update min accordingly.
 */


public class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;

    }

    public void push(int val) {
        if (val <= min) {
            st.push(min); //push previous min to stack
            st.push(val);
            min = val; // update the min with the current min value
        } else {
            st.push(val);
        }
    }

    public void pop() {
        int poppedValue = st.pop();
        if (poppedValue == min) {
            min = st.pop(); //pop the previous minimum and update the min value
        }
    }

    public int top() {
        return st.peek().intValue();
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

/**
 * Time Complexity is O(1) for all the operations
 * Space Complexity is O(N)
 * Did this code successfully run on Leetcode : yes
 */
