// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.* ;
class MinStack {
    Stack<Integer> myStk;
    Stack<Integer> minStk;

    public MinStack() {
        myStk = new Stack<>();
        minStk = new Stack<>();
    }

    public void push(int val) {
        if(minStk.isEmpty() || minStk.peek() >= val) {
            minStk.push(val);
        }
        myStk.push(val);
    }

    public void pop() {
        int topElement = myStk.pop();
        if(minStk.peek() == topElement) {
            minStk.pop();
        }
    }

    public int top() {
        if (!myStk.isEmpty()) {
            return myStk.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!minStk.isEmpty()) {
            return minStk.peek();
        }
        return -1;

    }
}