// Time Complexity - push: O(1), pop: O(1), top: O(1), getMin: O(1)
// Space Complexity - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
The program pushes the previous minimum and current value on to the stack and calculates new minimum.
It pops the top 2 value from the stack as it is the top most value and current minimun.
Peek returns the topmost value from the stack and getmin returns the minimum value
*/

import java.util.Stack;

class MinStack {

    int min;
    Stack<Integer> stack1;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        stack1 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(min);
        stack1.push(val);
        min = Math.min(min, val);
    }

    public void pop() {

        stack1.pop();
        min = stack1.pop();
    }

    public int top() {
        return stack1.peek();
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