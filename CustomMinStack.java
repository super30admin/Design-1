import java.util.Stack;

// Time Complexity
// push() : O(1)
// pop() : O(1)
// top() : O(1)
// getMin() : O(1)

// Space Complexity - Previous min saved on same stack
// push() : O(1)
// pop() : O(1)
// top() : O(1)
// getMin() : O(1)

// Constraints:
// -2^31 <= val <= 2^31 - 1
// Methods pop, top and getMin operations will always be called on non-empty stacks.
// At most 3 * 104 calls will be made to push, pop, top, and getMin.

public class CustomMinStack {
    class MinStack {
        private Stack<Integer> stack;
        private int min;

        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if (val <= min) {
                stack.push(min); // Save previous min on stack
                min = val; // New min
            }
            stack.push(val); // Push current value
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }

            int currentTop = stack.pop();

            if (currentTop == min) {
                min = stack.pop(); // Set min to previous min
            }
        }

        public int top() {
            return stack.peek();
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
