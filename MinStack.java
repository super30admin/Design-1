// Time Complexity : O(1) for push, pop, top, getMin
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

import java.util.Stack;

class MinStack {

    Stack<Integer> nStack;
    Stack<Integer> minStack;

    public MinStack() {
        nStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {

        nStack.push(val);

        if(!minStack.isEmpty()){

            if(val < minStack.peek()){
                minStack.push(val);
            }else{
                minStack.push(minStack.peek());
            }

        }else{
            minStack.push(val);
        }
    }

    public void pop() {
        nStack.pop();
        minStack.pop();

    }

    public int top() {
        return nStack.peek();
    }

    public int getMin() {
        return minStack.peek();
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