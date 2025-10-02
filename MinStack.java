// Time Complexity : O(1) for all the operations done below
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Just the approach of maintaining one more stack for minimum values made the problem better. We also discussed
// achieving it with single array by maintaining a min value, pushing min value and element together if minimum value changed.

// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        min = Math.min(val,min);
        stack.push(val);
        minStack.push(min);
    }

    public void pop() {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */