// Time Complexity : O(1)
// Space Complexity : O(n) //since we don't know the size of stack
// Did this code successfully run on Leetcode : Yes

package com.madhurima;

import java.util.LinkedList;
import java.util.Stack;

public class Problem2 {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(10);
        ms.push(2);
        ms.push(11);
        System.out.println(ms.getMin());
        System.out.println(ms.top());
        ms.pop();
        ms.pop();
        System.out.println(ms.getMin());
        System.out.println(ms.top());
    }
}

class MinStack {
    Stack<Integer> s;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        s = new Stack<>();
    }

    public void push(int val) {
        if(val <= min){
            s.push(min);
            s.push(val);
            min = val;
        }else{
            s.push(val);
        }
    }

    public void pop() {
        if(s.peek() == min){
            s.pop();
            min = s.pop();
        }else{
            s.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}
