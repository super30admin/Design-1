// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
*  Used two stack. One to hold the actual values.
* other to hold the minimum value for the corresponding original value
*
* */

import java.util.Stack;

class MinStack {

    private Stack<Integer> mainStack ;
    private Stack<Integer> secStack;
    public MinStack() {
        mainStack = new Stack<>();
        secStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if(secStack.isEmpty()){
            secStack.push(val);
        } else if(secStack.peek() > val){
            secStack.push(val);
        } else {
            secStack.push(secStack.peek());
        }
    }

    public void pop() {
        secStack.pop();
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return secStack.peek();
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