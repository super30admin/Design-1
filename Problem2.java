import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class Problem2 {

    // Here I am using a single stack, and I store previous min followed by current value. The intuition here is that
    // if we pop out a element then we need to know what was my previous min element and accordingly we update the min variable
    class MinStack {

        Stack<Integer> s;
        int min;

        public MinStack() {
            s = new Stack();
            min = Integer.MAX_VALUE;
        }

        // if the incoming element is new min then we push previous min and then incoming element, also update the min
        public void push(int val) {
            if (val <= min) {
                s.push(min);
                min = val;
            }
            s.push(val);
        }

        // While popping we check if we are popping the min element, in that case we also the previous min and make it the new min
        public void pop() {
            int popped = s.pop();
            if (popped == min) {
                min = s.pop();
            }
        }

        public int top() {
            return s.peek();
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
}
