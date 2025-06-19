// Time Complexity : O(1) for push, pop, top, and getMin operations
// Space Complexity : O(n) for the stack storage
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No problems faced


// Your code here along with comments explaining your approach
// Approach:
// Used a single stack to store values, and push the previous minimum before pushing a new minimum.
// Maintained a separate variable `min` to track the current minimum at all times.
// On pop, if the popped value is equal to `min`, pop again to restore the previous minimum.

class MinStack {
    Stack<Integer> s;
    int min;

    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min){
            s.push(min); // push the current minimum onto the stack
            min = val; // update the minimum to the new value
        }
        s.push(val); // push the new value onto the stack
    }

    public void pop() {
        int popped = s.pop();
        // If the popped value is the current minimum, pop it again to restore the previous minimum
        if (popped == min){
            min = s.pop();
        }
    }

    public int top() {
        return s.peek();
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