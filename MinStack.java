// Time Complexity : O(1)
// Space Complexity : O(n) - additional space for min stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Tried to eliminate use of an extra stack

// Your code here along with comments explaining your approach
// 1. Maintain the current minimum in a separate stack
// 2. Push - if min_stack.top() >= x, push into min_stack
// 3. Pop - if popped elements is curr_min, remove from min_stack

import java.util.Stack;
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (min.empty()) {
            min.push(x);
        } else if (min.peek() >= x) {
            min.push(x);
        }
    }
    
    public void pop() {
        int popped = stack.pop();
        if (!min.empty() && min.peek() == popped) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */