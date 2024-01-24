import java.util.Stack;

// Time Complexity
// push() : O(1)
// pop() : O(1)
// top() : O(1)
// getMin() : O(1)

// Space Complexity - O(N) for extra stack
// push() : O(1)
// pop() : O(1)
// top() : O(1)
// getMin() : O(1)

// Constraints:
// -2^31 <= val <= 2^31 - 1
// Methods pop, top and getMin operations will always be called on non-empty stacks.
// At most 3 * 104 calls will be made to push, pop, top, and getMin.

public class CustomMinStackWithExtraSpace {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            int val = stack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
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
