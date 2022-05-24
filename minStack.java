// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes I have not understand how to get minimum element.
// So, I have taken a refrences from google.

import java.util.Stack;

class MinStack {

    // declare two stack one for storing element and another is for storing minimum
    // element.
    private Stack<Integer> stk = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {

        // push element in stack
        stk.push(val);

        // check if minimum stackis empty or element we are pushing are less than or
        // equal
        // to elements in min stack push new element in min stack
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }

    public void pop() {

        // check wheather top element in stack is equals to top element in min stack
        // means that we are poping minimum element in stack so, we are poping from min
        // stack also.
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

        // here always in min stack top element is minimum in stack. So, to get minimum
        // element we jusst peek top element in min stack/
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(22);
        minStack.push(-1);
        minStack.push(0);
        minStack.push(-11);
        minStack.push(11);
        System.out.println("Minimum element in stack is: " + minStack.getMin());
        System.out.println("top element in stack is: " + minStack.top());
        minStack.pop();
        minStack.pop();
        System.out.println("Minimum element in stack is: " + minStack.getMin());

    }
}