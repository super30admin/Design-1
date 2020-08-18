// Time Complexity
// push(x), pop(), top(), getMin(): O(1)

// Space Complexity
// O(N + N) due to maintaining two stacks

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was I supposed to do it using array or builtin?


/**
 * MinStack using array
 */
class MinStack {

    private static final int MAX = 100000;  // Maximum size of Stack
    int top;                                // top of stack
    int[] stack = new int[MAX];
    int[] minStack = new int[MAX];

    /**
     * initialize MinStack
     */
    public MinStack() {
        top = -1;
    }

    public void push(int x) {
        if (top < (MAX - 1)) {
            int min = (top < 0 || x < minStack[top]) ? x : minStack[top];       // Calculate current minimum
            top++;
            stack[top] = x;
            minStack[top] = min;
        }
    }

    public void pop() {
        if (top >= 0) {
            top--;
        }
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[top];
    }
}