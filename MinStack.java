// Time Complexity : O(1)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// 1. We create 2 stacks to keep track of the values that are coming in.
// 2. Stack is used to keep track of the incoming elements.
// 3. MinStack is used to keep track of the minimum element available in the list.
// 4. When a new element comes in, we insert that element into regular stack.
// We compare the current element with the top element of the minstack 
// and whichever is smaller we store that again as a new element on top of min stack.
// 5. when we do a pop, we simply remove the top elements from both the stacks.


import java.util.*;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        /* If the stack is empty, then the min value
         * must just be the first value we add. */
        int min = Math.min(minStack.peek(), x);
        stack.push(x);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(4);
        obj.push(15);
        obj.push(2);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }
}