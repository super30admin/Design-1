
// Time Complexity : push, pop, top and getMin have time complexity of O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



import java.util.*;
class MinStack {

    private Stack<Integer> stack;
    private int minElement;

    public MinStack() {
        stack = new Stack<>();
        minElement = Integer.MAX_VALUE;
    }


    /*
        During the push operation, if the new value (val) is less than or equal to the current minimum value (minElement),
        we push the current minElement to the stack and then update minElement to hold the value of val. Then we push
        the new value (val) onto the stack. This ensures we always have the previous minimum element stored below the
        current minimum element in the stack.

     */

    public void push(int val) {
        if (val <= minElement) {
            stack.push(minElement);
            minElement = val;
        }
        stack.push(val);
    }


    /*

        During the pop operation, if the element being popped from the stack is equal to minElement, we pop
        another element from the stack which represents the previous minimum element and store it to minElement

     */

    public void pop() {
        if (stack.pop() == minElement) {
            minElement = stack.pop();
        }
    }


    /*
        The top function utilizes the peek function of the stack to return the top value
     */

    public int top() {
        return stack.peek();
    }

    /*
        As we stored the minimum element from the beginning, we can return it using the variable minElement
     */
    public int getMin() {
        return minElement;
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