import java.util.Stack;

//Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MinStack {

    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    //Time Complexity: O(1)
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }

        stack.push(x);
    }

    //Time Complexity: O(1)
    public void pop() {
        int val = stack.pop();
        if (val == min) {
            min = stack.pop();
        }


    }

    //Time Complexity: O(1)
    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    //Time Complexity: O(1)
    public int getMin() {
        return min;
    }
}