// Time Complexity : 0(1)
// Space Complexity : number of push operations
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : N/A


class MinStack {

    Stack<Integer> normal;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        normal = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        min = Math.min(min,val);
        normal.push(val);
        minStack.push(min);
    }

    public void pop() {
        normal.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min;
    }
}
