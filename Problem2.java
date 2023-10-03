// Time Complexity :
// push(): O(1)
// pop(): O(1)
// top(): O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.io.*;
import java.util.*;
class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minStack;
    private int min;
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minStack = new Stack<>();
        this.minStack.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        this.min = minStack.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

class Problem2
{
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(3);
        obj.push(6);
        obj.push(-1);
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }
}