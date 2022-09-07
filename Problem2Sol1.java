// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Solution 1
class MinStack {
    // We need 2 stack to maintain the value of minimum at each level
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        // Initialize both stacks and push value of min in minStack
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }

    public void push(int val) {
        // Determine min by comparing with val and push min in minStack and val in stack
        min = Math.min(min, val);
        stack.push(val);
        minStack.push(min);
    }

    public void pop() {
        // pop from both the stacks and update min with the top value of minStack
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}