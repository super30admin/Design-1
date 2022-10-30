// Time Complexity : O(1) for all operations
// Space Complexity : O(n) in worst case scenario if all push operation wish descending order
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.Stack;

class MinStack2 {

    Stack<Integer> stack;
    int min;
    public MinStack2() {
        this.stack = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int peek = top();
        if (peek == min) {
            stack.pop();
            min = top();
        }
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}