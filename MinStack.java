// Time Complexity : O(1) time for all functions - push(), pop(), top(), getMin(), peek()
// Space Complexity : 2 stacks = O(2N) = O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */

    // To store input
    Stack<Integer> stack;

    // To track minValues
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }
    public void push(int x) {
        // If minStack is empty or the current element is less than the top element of minStack, then add the current element to minStack as well as to the stack that stores input. Otherwise, only add to the later stack.
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }

    public void pop() {
        // If the Stack's and minStack's top element are same, pop that element from both the stacks, otherwise opo it only from the    input Stack
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        // Input stack's top element can be found by just calling peek() on it.
        return stack.peek();
    }

    public int getMin() {
        // Since we are tracking min values in MinStack, the top of minStack will always have the minimum value so far. So just call peek() on minStack to get the minimum element
        return minStack.peek();
    }
}
public class Solution {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.getMin(); // return -3
        obj.pop();
        obj.top();    // return 0
        obj.getMin(); // return -2
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
