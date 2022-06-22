import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

class MinStack {
    Stack<Integer> s;
    Stack<Integer> min_stack;
    int min;

    public MinStack() {
        s = new Stack<>();
        min_stack = new Stack<>();
        min = Integer.MAX_VALUE; // to understand the min_stack is empty.
        min_stack.push(min);
    }

    public void push(int val) {
        min = Math.min(min, val); // checking for minimum with previous min and current val tp push onto the
                                  // min_stack.
        s.push(val);
        min_stack.push(min);
    }

    public void pop() {
        s.pop();
        min_stack.pop();
        min = min_stack.peek(); // updating min to the topmost element on the min_stack.

    }

    public int top() {
        return s.peek();

    }

    public int getMin() {
        return min;
    }

    public static void main(String args[]) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.pop();
        obj.top();
        obj.getMin();

    }

}
