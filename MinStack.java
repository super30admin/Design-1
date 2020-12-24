// Time Complexity :0(1)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced issuses when attempting single stack approach but settled on double
//stack approach


// Your code here along with comments explaining your approach


import java.util.Stack;

class MinStack {
    //declare variables of type stack
    private Stack<Integer> stack, minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        //push value on to stack, for minstack push x if it is empty or x is lower than top value on minstack else
        //push top value on minstack again.
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        //pop values from both stack and minstack
        stack.pop();
        minStack.pop();
    }

    public int top() {
        //read top value of stack
        return stack.peek();
    }

    public int getMin() {
        //read top value of minstack
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */