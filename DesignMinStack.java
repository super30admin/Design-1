package S30.Design_1;

// Time Complexity : Push: O(1), Pop: O(1), Top: O(1), Min: O(1)
// Space Complexity : O(2*n) = O(n) - worse case, when elements coming in decreasing order
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


import java.util.Stack;

public class DesignMinStack {

    int size = 0;
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public DesignMinStack() {
        this.stack = new Stack<Integer>();

    }

    //Push the previous minimum right below the current minimum - 1 stack approach
    public void push(int x) {

        if(x <= min) {
            stack.push(min);
            min = x;
            ++size;
        }
        stack.push(x);
        ++size;

    }

    public void pop() {
        if(size == 0) return;

        int popped = stack.pop();
        if(popped == min){
            min = stack.pop();
            size --;
        }
        size --;


    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;

    }
}
