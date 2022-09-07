// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//We are creating one more stack and storing smallest number so that in the minstack, the top element is always the smallest, 
//also before removing the element we check if that is the top in the minstack, is so we remove it from the minstack as well.

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minstack = new Stack();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (minstack.size() == 0 || val <= minstack.peek()) {
            minstack.push(val);
        }
    }

    public void pop() {
        int top = top();
        stack.pop();
        if (minstack.size() != 0 && top == minstack.peek()) {
            minstack.pop();
        }
    }

    public int top() {
        int top = stack.peek();
        return top;
    }

    public int getMin() {
        int min = minstack.peek();
        return min;
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