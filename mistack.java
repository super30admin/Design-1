// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : refered online to understand hot to get minimum element

import java.util.Stack;
class MinStack {

    // declare two stack one for storing element and one for storing minimumelement.
    private Stack<Integer> stk = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {

        // push element in stack
        stk.push(val);

        // check if minimum stack empty or element we are pushing are less than ormequal
        // to elements in min stack push new element in min stack
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }

    public void pop() {

        // check wheather top element in stackequals to top element in min stack
        // we are poping minimum element in stack so, we are poping from min stack aswell.
        if (stk.peek().equals(min.peek())) {
            min.pop();
        }
        stk.pop();
    }

    public int top() {

        // return top element from stack
        return stk.peek();
    }

    public int getMin() {

        // here always in min stack top element is minimum in stack. So, to get minimum element we canjust peek top element in min stack/
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(44);
        minStack.push(-1);
        minStack.push(0);
        minStack.push(-11);
        minStack.push(55);
        System.out.println("Minimum element in stack is: " + minStack.getMin());
        System.out.println("top element in stack is: " + minStack.top());
        minStack.pop();
        minStack.pop();
        System.out.println("Minimum element in stack is: " + minStack.getMin());

    }
} 