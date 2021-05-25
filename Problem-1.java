import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

class MinStack {

    // Internal stack data structure to hold pair of value and min value till that
    // item
    private Stack<int[]> _stack;

    /** initialize your data structure here. */
    public MinStack() {
        _stack = new Stack<int[]>();
    }

    public void push(int val) {
        if (_stack.isEmpty()) {
            // Pushing first item in stack, minvalue will be same as value
            _stack.push(new int[] { val, val });
        } else {
            // When stack is not empty then get the existing min value to compare and update
            // current min value
            int existingMinValue = _stack.peek()[1];
            int currentMinValue = Math.min(val, existingMinValue);

            _stack.push(new int[] { val, currentMinValue });
        }
    }

    public void pop() {
        _stack.pop();
    }

    public int top() {
        // incase stack is empty returning Integer.MIN_VALUE;
        return _stack.isEmpty() ? Integer.MIN_VALUE : _stack.peek()[0];
    }

    public int getMin() {
        // incase stack is empty returning Integer.MIN_VALUE;
        return _stack.isEmpty() ? Integer.MIN_VALUE : _stack.peek()[1];
    }

    public boolean isEmpty() {
        return _stack.isEmpty();
    }

    public boolean isFull() {
        return false;
    }
}
