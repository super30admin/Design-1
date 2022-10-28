// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

package com.madhurima;

import java.util.LinkedList;

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

    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minVals = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.addFirst(val);

        if(minVals.isEmpty()){
            minVals.addFirst(val);
        }else if(val < minVals.getFirst()){
            minVals.addFirst(val);
        }else{
            minVals.addFirst(minVals.getFirst());
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }else{
            stack.removeFirst();
            minVals.removeFirst();
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minVals.getFirst();
    }


}
