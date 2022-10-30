// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is number elements of hashCode. We used another stack to maintain min value with 1:1 corresponds
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.Stack;

class MinStack1 {

    Stack<Integer> dataStack, minStack;
    int min;

    public MinStack1() {
        dataStack = new Stack();
        minStack = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        min = Math.min(val, min);
        dataStack.push(val);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        if (minStack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = minStack.peek();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}