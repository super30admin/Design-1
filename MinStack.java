// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Solution was tricky to come up with. Referred leetcode resources.
class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }
        int currentMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x, currentMin)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}