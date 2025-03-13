import java.util.*;

// Time Complexity:
// Push Operation: O(1)
// Pop Operation: O(1)
// Top Operation: O(1)
// getMin Operation: O(1)

// Space Complexity: O(2N) as there are two stacks we are using
// but since constants does not matter thus O(N)

// Runs on Leetcode: Yes

class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }


    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            if (popped == minStack.peek()) {
                minStack.pop();
            }
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