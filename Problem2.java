/**
 * // Time Complexity : O(1)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : yes
 */
/

class MinStack {
    // using stack of array to store num and min value
    private Stack<int[]> stack = new Stack<>();

    public MinStack() { }

    public void push(int x) {

        /* If the stack is empty, then the min value
         * must just be the first value we add. */
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }

        int currentMin = stack.peek()[1];

        /*
        push the value and min value in the stack
        */
        stack.push(new int[]{x, Math.min(x, currentMin)});
    }

    public void pop() {
        stack.pop();
    }

    /*
    return the top value from the stack
     */
    public int top() {
        return stack.peek()[0];
    }

    // return the min value in the stack
    public int getMin() {
        return stack.peek()[1];
    }
}