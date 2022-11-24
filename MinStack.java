// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* 
 * Create 2 stacks - one will contain all the values and other will contain the next minimum value
 * for push -> push the current element to the stack , if the minstack is empty or the current value is less than the top element of mins stack, push in minstack as well.
 * For pop -> check the if the value to be removed from stack is same as min stack, if so remove the vaue from minstack as well.
 * top -> return the last eleemnt inserted in stack
 * getMin -> reeturn the top element in minstack
 */
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
