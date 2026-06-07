// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Description:
// - Store all values in the main stack.
// - Store the minimum value seen so far at each corresponding position in a second stack.
// - When popping, the top of the min stack automatically reveals the minimum for the remaining elements.

class MinStack {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;
    private int min;

    public MinStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int value) {
        stack1.push(value);
        this.min = Math.min(min, value);
        stack2.push(this.min);
    }

    public void pop() {
        if(stack1.isEmpty()) {
            return;
        }

        stack1.pop();
        stack2.pop();
        if(stack2.isEmpty()) {
            this.min = Integer.MAX_VALUE;
        } else {
            this.min = stack2.peek();
        }
    }

    public int top() {
        if(stack1.isEmpty()) {
            return -1;
        }

        return stack1.peek();
    }

    public int getMin() {
        return this.min;
    }
}