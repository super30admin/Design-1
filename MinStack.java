// MinStack
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }

    public void pop() {
        int popped = stack.pop();
        if (popped == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min;

    }
}
