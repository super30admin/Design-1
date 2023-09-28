// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
public class MinStack {
        private int min;
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            this.min = Integer.MAX_VALUE;
            this.stack = new Stack<>();
            this.minStack = new Stack<>();

            minStack.push(min);
        }

        public void push(int val) {
            min = Math.min(min, val);
            stack.push(val);
            minStack.push(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            this.min = minStack.peek();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
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
