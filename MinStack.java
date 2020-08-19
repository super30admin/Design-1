//Time Complexity: O(1)
//Space complexity: O(1) apart from stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> s1;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        s1 = new Stack<>();
    }

    public void push(int x) {
        if(x<=min){
            s1.push(min);
            min = x;
        }
        s1.push(x);
    }

    public void pop() {
        int n = s1.pop();
        if(min==n){
            min = s1.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.getMin();
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